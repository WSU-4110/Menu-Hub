package com.example.menuhub;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;

/**
 * An Email format validator for {@link android.widget.EditText}.
 */
public class UserValidator implements TextWatcher {
    /**
     * Email validation pattern.
     */
    public static final Pattern USER_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    /**
     * Check the validation of password, no longer than 25
     *
     * @param pass
     * @return
     */
    public static boolean validPassLen(String pass) {
        if (pass.length() > 25)
            return false;

        return true;
    }

    public static boolean validPassFormat(String pass) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";

        return pass.matches(regex);
    }
    /**
     * Validates if the given input is a valid email address.
     *
     * @param email The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidUser(CharSequence email) {
        return email != null && USER_PATTERN.matcher(email).matches();
    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidUser(editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}