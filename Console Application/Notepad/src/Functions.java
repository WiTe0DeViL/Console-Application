public class Functions {
    Window gui;

    public void function(Window gui) {
        this.gui = gui;
    }

    public void fileFunction() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

}
