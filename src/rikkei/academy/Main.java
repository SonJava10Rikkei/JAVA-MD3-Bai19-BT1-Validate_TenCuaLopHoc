package rikkei.academy;

import rikkei.academy.config.ColorConfig;
import rikkei.academy.config.Config;
import rikkei.academy.validate.ValidateClassName;
import rikkei.academy.validate.ValidateInput;

public class Main {
    public Main() {
        while (true) {
            System.out.println("******************** Menu ********************");
            System.out.println("1. Để nhập tên lớp \n" +
                    "0. Để thoát chường trình"
            );
            int chooseMenu = ValidateInput.validateInt();
            switch (chooseMenu) {
                case 1:
                    checkClassName();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập menu từ 0 or 1 mời chọn lại: ");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public void checkClassName() {
        ValidateClassName validateCheck = new ValidateClassName();
        while (true) {
            System.out.println("Nhập tên lớp: ");
            String className = Config.scanner().nextLine();
            boolean checkName = validateCheck.validate(className);
            if (checkName) {
                System.out.println("___ Lớp: " + className + " là " + checkName);

                System.out.println("|     Nhập 'M' để quay lại Menu,                              |");
                System.out.println("|     hoặc nhập phím khác để tiếp tục thêm tên lớp            |");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("m")) {
                    new Main();
                }
            } else {
                System.out.println("___Lớp: " + "\'" + className + "\'" + " là " + checkName);
                System.out.println(ColorConfig.RED + "Tên lớp phải :\n" +
                        "Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P\n" +
                        "Không chứa các ký tự đặc biệt\n" +
                        "Theo sau ký tự bắt đầu là 4 ký tự số \n" +
                        "Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M\n" + ColorConfig.RESET);
                System.out.println("Mời nhập lại ! ");
            }

        }

    }
}
