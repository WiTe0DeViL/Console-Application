package bankConsoleApplication;

class UserList {

    UserList() {
        hardCode();
    }

    final static String[][] users = {
            {"suren", "21", "suren@gamil.com", "Suren@021"},
            {"Gopal", "21", "gopal@gamil.com", "Gopal@021"},
            {"Vipi", "21", "vipi@gamil.com", "Vipi@021"},
            {"Vicky", "21", "vicky@gamil.com", "Vicky@021"},
            {"Sanjaya", "21", "sanjaya@gamil.com", "Sanjaya@021"},
            {"Bhavya", "21", "bhavya@gamil.com", "Bhavya@021"},
            {"Nandhini", "21", "nandhini@gamil.com", "Nandhini@021"},
    };

    private static void hardCode() {
        for (String[] user : users)
            new BankingProcess().userList.add(new User(user[0], Integer.parseInt(user[1]), user[2], user[3]));
    }

}
