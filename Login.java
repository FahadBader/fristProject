import java.awt.EventQueue;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.Font;
public class Login extends JFrame implements ActionListener {
private JFrame frmLogin;
private JTextField UserID;
private JPasswordField passwordField;
JButton submit;
JButton Cancel;
EmployeeRegistration er;
newFrame regFace;
/**
* Launch the application.
*/
public static void main(String[]args) {
try{
Login window =new Login();
window.frmLogin.setVisible(true);
window.pack();
}catch(Exception e) {
e.printStackTrace();
}
}
/**
* Create the application.
*/
public Login() {
super("Login");
initialize();
}
/**
* Initialize the contents of the frame.
*/
private void initialize() {
//JPanel panel=new JPanel();
frmLogin = new JFrame();
frmLogin.setTitle("Login ");
er = new EmployeeRegistration();
frmLogin.setBounds(100, 100, 450, 300);
frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmLogin.getContentPane().setLayout(null);
JLabel label=new JLabel("User ID");
label.setBounds(45, 58, 76, 14);
frmLogin.getContentPane().add(label);
Cancel = new JButton("Cancel");
Cancel.setBounds(259, 159, 89, 23);
frmLogin.getContentPane().add(Cancel);
Cancel.addActionListener(this);
UserID = new JTextField();
UserID.setColumns(10);
UserID.setBounds(149, 55, 180, 20);
frmLogin.getContentPane().add(UserID);
JLabel label_1 =new JLabel("PassWord");
label_1.setBounds(45, 110, 76, 14);
frmLogin.getContentPane().add(label_1);
passwordField = new JPasswordField();
passwordField.setEchoChar('*');
passwordField.setBounds(149, 106, 180, 23);
frmLogin.getContentPane().add(passwordField);
submit = new JButton("Submit");
submit.setBounds(160, 159, 89, 23);
frmLogin.getContentPane().add(submit);
submit.addActionListener(this);
JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setBounds(94, 22, 195,-1);
frmLogin.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Login Form");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
lblNewLabel_1.setBounds(149, 22, 123, 22);
frmLogin.getContentPane().add(lblNewLabel_1);
}
public JFrame getFrame() {
return frmLogin;
}
public void setFrame(JFrame frame) {
this.frmLogin = frame;
}
private static boolean isPasswordCorrect(char[] input) {
boolean isCorrect = true;
char [] correctPassword = {'P','a','s','s','w','o','r','d'};
if(input.length!=correctPassword.length) {
isCorrect = false;
}
else{
isCorrect = Arrays.equals(input,correctPassword);
}
//Zero out the password.
Arrays.fill(correctPassword,'0');
return isCorrect;
}
public void actionPerformed(ActionEvent evt) {
String usernameLogin = UserID.getText();
char [] passwordLogin = passwordField.getPassword();
if(evt.getActionCommand().equals("Submit")){
if(usernameLogin.equalsIgnoreCase("Fahad") && isPasswordCorrect(passwordLogin)){
regFace = new newFrame();
regFace.setVisible(true);
dispose();
}
else{
JOptionPane.showMessageDialog(null,"Wrong Password / Username");
UserID.setText("");
passwordField.setText("");
UserID.requestFocus();
}
if(evt.getActionCommand().equals("Cancel"))
frmLogin.setVisible(false);
}
}
}