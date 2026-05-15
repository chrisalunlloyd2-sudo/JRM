package com.jrm.chronos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.ViewGroup;
import android.view.Gravity;
import android.view.View;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText usernameInput;
    private EditText passwordInput;
    private boolean isDarkMode = true; // DEFAULT TO DARK MODE
    private String currentTab = "DASHBOARD";

    // Theme Colors
    private String getBgColor() { return isDarkMode ? "#121212" : "#F5F5F6"; }
    private String getCardBgColor() { return isDarkMode ? "#1E1E1E" : "#FFFFFF"; }
    private String getMainTextColor() { return isDarkMode ? "#E0E0E0" : "#2C3E50"; }
    private String getSubTextColor() { return isDarkMode ? "#B0B0B0" : "#444444"; }
    private String getHeaderTextColor() { return isDarkMode ? "#CCCCCC" : "#34495E"; }
    private String getHighlightBgColor() { return isDarkMode ? "#2E4C3D" : "#D5F5E3"; }
    private String getButtonBgColor() { return isDarkMode ? "#2980B9" : "#3498DB"; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoginScreen();
    }

    private void showLoginScreen() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setBackgroundColor(Color.parseColor(getBgColor()));
        layout.setGravity(Gravity.CENTER);
        int padding = 60;
        layout.setPadding(padding, padding, padding, padding);

        TextView title = new TextView(this);
        title.setText("JRM Chronos");
        title.setTextSize(29);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.parseColor(getMainTextColor()));
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 80);
        layout.addView(title);

        usernameInput = new EditText(this);
        usernameInput.setHint("Username");
        usernameInput.setTextSize(15);
        usernameInput.setTextColor(Color.parseColor(getMainTextColor()));
        usernameInput.setHintTextColor(Color.parseColor(getSubTextColor()));
        usernameInput.setBackgroundColor(Color.parseColor(getCardBgColor()));
        usernameInput.setPadding(30, 30, 30, 30);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 40);
        usernameInput.setLayoutParams(params);
        layout.addView(usernameInput);

        passwordInput = new EditText(this);
        passwordInput.setHint("Password");
        passwordInput.setTextSize(15);
        passwordInput.setTextColor(Color.parseColor(getMainTextColor()));
        passwordInput.setHintTextColor(Color.parseColor(getSubTextColor()));
        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordInput.setBackgroundColor(Color.parseColor(getCardBgColor()));
        passwordInput.setPadding(30, 30, 30, 30);
        passwordInput.setLayoutParams(params);
        layout.addView(passwordInput);

        Button loginButton = new Button(this);
        loginButton.setText("LOGIN");
        loginButton.setTextSize(13);
        loginButton.setBackgroundColor(Color.parseColor(getButtonBgColor()));
        loginButton.setTextColor(Color.WHITE);
        loginButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        
        loginButton.setOnClickListener(this);
        layout.addView(loginButton);

        // Add Toggle Theme button to login screen as well
        Button themeBtn = new Button(this);
        themeBtn.setText("TOGGLE THEME");
        themeBtn.setTextSize(10);
        themeBtn.setBackgroundColor(Color.parseColor(getBgColor())); // Blend in
        themeBtn.setTextColor(Color.parseColor(getSubTextColor()));
        LinearLayout.LayoutParams themeParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        themeParams.setMargins(0, 40, 0, 0);
        themeBtn.setLayoutParams(themeParams);
        themeBtn.setOnClickListener(this);
        layout.addView(themeBtn);

        setContentView(layout);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            String text = ((Button)v).getText().toString();
            if ("LOGIN".equals(text)) {
                if (usernameInput != null && passwordInput != null) {
                    if ("Boss".equals(usernameInput.getText().toString()) && "Boss".equals(passwordInput.getText().toString())) {
                        showMainScreen();
                    } else {
                        Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if ("TOGGLE THEME".equals(text)) {
                isDarkMode = !isDarkMode;
                if (usernameInput != null && usernameInput.getParent() != null) {
                     showLoginScreen();
                } else {
                     showMainScreen();
                }
            } else if ("DASHBOARD".equals(text) || "SHIFTS".equals(text) || "PAYROLL".equals(text) || "BIDS".equals(text)) {
                currentTab = text;
                showMainScreen();
            }
        }
    }

    private void showMainScreen() {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scrollView.setBackgroundColor(Color.parseColor(getBgColor()));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        int padding = 40;
        layout.setPadding(padding, padding, padding, padding);

        // Top bar for Title and Theme Toggle
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        topBar.setGravity(Gravity.CENTER_VERTICAL);
        topBar.setPadding(0, 0, 0, 30);

        TextView header = new TextView(this);
        header.setText("Welcome, Boss");
        header.setTextSize(23);
        header.setTypeface(null, Typeface.BOLD);
        header.setTextColor(Color.parseColor(getMainTextColor()));
        header.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        topBar.addView(header);

        Button themeBtn = new Button(this);
        themeBtn.setText("TOGGLE THEME");
        themeBtn.setTextSize(10);
        themeBtn.setBackgroundColor(Color.parseColor(getButtonBgColor()));
        themeBtn.setTextColor(Color.WHITE);
        themeBtn.setOnClickListener(this);
        topBar.addView(themeBtn);

        layout.addView(topBar);

        // Action Buttons to navigate
        LinearLayout actionRow = new LinearLayout(this);
        actionRow.setOrientation(LinearLayout.HORIZONTAL);
        actionRow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        actionRow.addView(createActionButton("DASHBOARD"));
        actionRow.addView(createActionButton("SHIFTS"));
        actionRow.addView(createActionButton("PAYROLL"));
        actionRow.addView(createActionButton("BIDS"));
        layout.addView(actionRow);

        if ("DASHBOARD".equals(currentTab)) {
            layout.addView(createSectionHeader("November 2026 Calendar"));
            layout.addView(createCalendarGrid());
            layout.addView(createSectionHeader("Employee Details"));
            layout.addView(createCard("Name: Boss Administrator\nRole: Executive\nID: ADMIN-001\nDepartment: Management"));
            layout.addView(createSectionHeader("Weekly Planner"));
            layout.addView(createCard("MONDAY\n09:00 AM - 05:00 PM @ Downtown Clinic\n\nTUESDAY\n09:00 AM - 05:00 PM @ Westside Hospital\n\nWEDNESDAY\n09:00 AM - 05:00 PM @ Main Office\n\nTHURSDAY\n09:00 AM - 05:00 PM @ Downtown Clinic\n\nFRIDAY\n09:00 AM - 05:00 PM @ Remote Working"));
            layout.addView(createSectionHeader("Current Hours"));
            layout.addView(createCard("Total Hours Logged: 40.0 hrs\nOvertime: 0.0 hrs\nStatus: Pending Verification"));
        } else if ("SHIFTS".equals(currentTab)) {
            layout.addView(createSectionHeader("Open Shifts"));
            layout.addView(createCard("Shift #1024 - ER Trauma\nLocation: Westside Hospital\nTime: 08:00 AM - 16:00 PM\nRole: Registered Nurse"));
            layout.addView(createCard("Shift #1025 - Outpatient Care\nLocation: Downtown Clinic\nTime: 10:00 AM - 18:00 PM\nRole: General Practitioner"));
            layout.addView(createCard("Shift #1026 - ICU Unit\nLocation: Main Hospital\nTime: 22:00 PM - 06:00 AM\nRole: Specialist"));
        } else if ("PAYROLL".equals(currentTab)) {
            layout.addView(createSectionHeader("Payroll History"));
            layout.addView(createCard("Pay Period: Nov 1 - Nov 15\nGross Pay: $2,450.00\nDeductions: $490.00\nNet Pay: $1,960.00\nStatus: Processed"));
            layout.addView(createCard("Pay Period: Nov 16 - Nov 30\nEst. Gross Pay: $912.50\nStatus: Pending"));
            layout.addView(createCard("Pay Period: Oct 15 - Oct 31\nGross Pay: $2,600.00\nDeductions: $520.00\nNet Pay: $2,080.00\nStatus: Processed"));
        } else if ("BIDS".equals(currentTab)) {
            layout.addView(createSectionHeader("My Active Bids"));
            layout.addView(createCard("Shift #882 - Site B (Night)\nFri, Nov 27 - 22:00 to 06:00\nStatus: [ PENDING APPROVAL ]"));
            layout.addView(createCard("Shift #741 - Downtown Clinic\nMon, Nov 23 - 09:00 to 17:00\nStatus: [ ACCEPTED ]"));
            layout.addView(createCard("Shift #710 - Westside ER\nSat, Nov 21 - 12:00 to 20:00\nStatus: [ REJECTED ]"));
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }

    private Button createActionButton(String text) {
        Button btn = new Button(this);
        btn.setText(text);
        btn.setTextSize(9);
        if (text.equals(currentTab)) {
            btn.setBackgroundColor(Color.parseColor(getHighlightBgColor()));
            btn.setTextColor(Color.parseColor(getMainTextColor()));
        } else {
            btn.setBackgroundColor(Color.parseColor(getButtonBgColor()));
            btn.setTextColor(Color.WHITE);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        params.setMargins(2, 5, 2, 20);
        btn.setLayoutParams(params);
        btn.setOnClickListener(this);
        return btn;
    }

    private TextView createSectionHeader(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(15);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.parseColor(getHeaderTextColor()));
        tv.setPadding(0, 30, 0, 15);
        return tv;
    }

    private TextView createCard(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(13);
        tv.setTextColor(Color.parseColor(getSubTextColor()));
        tv.setBackgroundColor(Color.parseColor(getCardBgColor()));
        tv.setPadding(40, 40, 40, 40);
        tv.setLineSpacing(0, 1.2f);
        
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 20);
        tv.setLayoutParams(params);
        return tv;
    }

    private LinearLayout createCalendarGrid() {
        LinearLayout calendar = new LinearLayout(this);
        calendar.setOrientation(LinearLayout.VERTICAL);
        calendar.setBackgroundColor(Color.parseColor(getCardBgColor()));
        calendar.setPadding(20, 20, 20, 20);
        
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 20);
        calendar.setLayoutParams(params);

        String[] days = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
        
        LinearLayout rowHeader = new LinearLayout(this);
        rowHeader.setOrientation(LinearLayout.HORIZONTAL);
        for (String day : days) {
            TextView tv = new TextView(this);
            tv.setText(day);
            tv.setTextSize(12);
            tv.setTextColor(Color.parseColor(getMainTextColor()));
            tv.setTypeface(null, Typeface.BOLD);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            rowHeader.addView(tv);
        }
        calendar.addView(rowHeader);

        int date = 1;
        for (int r = 0; r < 5; r++) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(0, 20, 0, 0);
            for (int c = 0; c < 7; c++) {
                TextView tv = new TextView(this);
                tv.setTextSize(12);
                if (date <= 30) {
                    tv.setText(String.valueOf(date));
                    if (date >= 9 && date <= 13) {
                        tv.setBackgroundColor(Color.parseColor(getHighlightBgColor()));
                        tv.setTextColor(Color.parseColor(getMainTextColor()));
                    } else {
                        tv.setTextColor(Color.parseColor(getSubTextColor()));
                    }
                    date++;
                } else {
                    tv.setText("");
                }
                tv.setGravity(Gravity.CENTER);
                tv.setPadding(0, 10, 0, 10);
                tv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
                row.addView(tv);
            }
            calendar.addView(row);
        }
        return calendar;
    }
}
