package com.example.banvetau.helper;

public class PasswordStrengthService {
    public static boolean isPasswordStrongEnough(String password) {
        // Xác định các điều kiện mà mật khẩu cần phải đáp ứng
        boolean isLengthValid = password.length() >= 8; // Độ dài tối thiểu là 8 ký tự
        boolean containsSpecialChar = !password.matches("[A-Za-z0-9 ]*"); // Chứa ít nhất 1 ký tự đặc biệt
        boolean containsUppercase = !password.equals(password.toLowerCase()); // Chứa ít nhất 1 ký tự viết hoa
        boolean containsLowercase = !password.equals(password.toUpperCase()); // Chứa ít nhất 1 ký tự viết thường
        boolean containsDigit = password.matches(".*\\d.*"); // Chứa ít nhất 1 số

        // Kiểm tra tất cả các điều kiện
        return isLengthValid && containsSpecialChar && containsUppercase && containsLowercase && containsDigit;
    }
}
