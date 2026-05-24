package com.jrm.chronos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = "com.jrm.chronos")
@org.springframework.data.jpa.repository.config.EnableJpaRepositories(basePackages = "com.jrm.chronos.domain.repository")
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages = "com.jrm.chronos.domain")
@EnableJpaAuditing
public class ChronosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChronosApplication.class, args);
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.boot.CommandLineRunner dataSeeder(
            com.jrm.chronos.domain.repository.UserRepository userRepository,
            com.jrm.chronos.domain.repository.RoleRepository roleRepository,
            com.jrm.chronos.domain.repository.StickyRepository stickyRepository,
            org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(com.jrm.chronos.domain.Role.builder().name("ROLE_USER").build());
                roleRepository.save(com.jrm.chronos.domain.Role.builder().name("ROLE_ADMIN").build());
            }

            if (userRepository.count() == 0) {
                com.jrm.chronos.domain.Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
                com.jrm.chronos.domain.User admin = com.jrm.chronos.domain.User.builder()
                        .username("Boss")
                        .password(passwordEncoder.encode("Boss"))
                        .email("admin@jrm.com")
                        .roles(java.util.Set.of(adminRole))
                        .enabled(true)
                        .build();
                userRepository.save(admin);

                stickyRepository.save(com.jrm.chronos.domain.Sticky.builder()
                        .title("Hardware Node: Dell XPS")
                        .content("Primary distributed node for stability tracking and long-term memory augmentation.")
                        .category("INFRASTRUCTURE")
                        .owner(admin)
                        .build());
            }
        };
    }
}
