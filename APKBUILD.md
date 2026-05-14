# JRM Chronos - APK Build Strategy & Blueprint

## The Challenge
Compiling a modern Spring Boot application directly into an Android APK presents a unique challenge: Android's `d8` (DEX compiler) does not support newer Java features like "Sealed Classes," which are heavily utilized within Spring Boot's internal `BOOT-INF` classloader and fat JAR structure. 

To overcome this, we orchestrated an **Isolate & Inject** strategy. By stripping away the Spring Boot runtime packaging and compiling only our raw module code (Thin JARs), we successfully bypassed the structural limitations and compiled the bytecode into Android's native DEX format.

*Note: You mentioned the success being linked to our 32-bit architecture context. This is highly probable, as 32-bit JVMs and Termux builds often handle memory allocation and certain bytecode translations differently, which can sometimes bypass strict 64-bit strict validation constraints.*

---

## The APK Build Topology

```text
[ Maven Build (Thin JARs) ]
   |-- domain-0.0.1-SNAPSHOT.jar
   |-- core-0.0.1-SNAPSHOT.jar
   |-- security-0.0.1-SNAPSHOT.jar
   |-- api-0.0.1-SNAPSHOT.jar
   |
[ DEX Conversion (d8) ]
   |-- Input: All 4 Thin JARs
   |-- Process: Desugaring & Bytecode translation
   |-- Output: classes.dex (Raw Android Bytecode)
   |
[ APK Initialization (aapt2) ]
   |-- Input: AndroidManifest.xml + android.jar
   |-- Output: chronos_test.apk (Empty Shell APK)
   |
[ DEX Injection (jar) ]
   |-- Input: chronos_test.apk + classes.dex
   |-- Output: chronos_test.apk (Code Injected)
   |
[ APK Signing (apksigner) ]
   |-- Input: nova.keystore + chronos_test.apk
   |-- Output: chronos_test.apk (Fully Signed & Verified)
```

---

## Exhaustive Build Steps

### Step 1: Generate Thin JARs
We must prevent Spring Boot from wrapping our code in its custom classloader. We do this by passing the `-Dspring-boot.repackage.skip=true` flag to Maven.

```bash
cd JRM
mvn clean package -DskipTests -Dspring-boot.repackage.skip=true
```
*Result: This gives us standard, flat Java JAR files in the `target/` directories of `domain`, `core`, `security`, and `api`.*

### Step 2: Convert Bytecode to DEX
We use Android's `d8` compiler to take the pure Java bytecode from our modules and convert it into a single `classes.dex` file.

```bash
mkdir -p build_dex
d8 domain/target/domain-0.0.1-SNAPSHOT.jar \
   core/target/core-0.0.1-SNAPSHOT.jar \
   security/target/security-0.0.1-SNAPSHOT.jar \
   api/target/api-0.0.1-SNAPSHOT.jar \
   --output build_dex
```

### Step 3: Create the Android Manifest
Android requires a manifest. We generate a minimal one.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.jrm.chronos">
    <application android:label="JRM Chronos">
    </application>
</manifest>
```

### Step 4: Link the APK Shell
We use `aapt2` to link the manifest against the Android framework (`android.jar`) to create the base APK structure.

```bash
cd build_dex
aapt2 link -o ../chronos_test.apk \
           -I /path/to/android.jar \
           --manifest AndroidManifest.xml
```

### Step 5: Inject the DEX File
Because the standard `zip` utility might be missing in some Termux environments, we use the Java `jar` tool (which manipulates zip archives) to update the APK by injecting our `classes.dex` into it.

```bash
jar uf ../chronos_test.apk classes.dex
```

### Step 6: Sign the APK
Android requires all APKs to be cryptographically signed. We use `apksigner` with the generated `nova.keystore`.

```bash
cd ..
apksigner sign --ks android/nova.keystore \
               --ks-pass pass:android \
               --key-pass pass:android \
               chronos_test.apk
```

**The APK is now successfully built, injected, and signed.**
