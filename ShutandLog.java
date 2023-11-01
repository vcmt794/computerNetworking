import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
public class ShutandLog {
    Runtime runtime;
    String os; //The Server's Operating system

    public ShutandLog(){//Constructor
        try {
            this.runtime = Runtime.getRuntime();
            this.os = System.getProperty("os.name").toLowerCase();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void Shutdown(int time){
        try {
            Process process;
            int exitcode = -1; // Exit code for checking whether Shutdown is successful
            if(this.os.contains("win")) {
                process = this.runtime.exec("shutdown /s /f /t " + Integer.toString(time));
                exitcode = process.waitFor();
            }
            else if(this.os.contains("nux")||this.os.contains("nix")||this.os.contains("mac")){
                process = this.runtime.exec("shutdown -h $(expr "+Integer.toString(time)+" / 60)");
                exitcode = process.waitFor();
            }

            if (exitcode == 0) {
                System.out.println("Shut down successfully");
            }else if(exitcode == -1){
                System.out.println("Unsupported operating system");
            } else {
                System.out.println("Shutdown fail. Exit code: "+exitcode);
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void Restart(int time){
        try {
            Process process;
            if(this.os.contains("win")) {
                process = this.runtime.exec("shutdown /s /f /t " + Integer.toString(time));
            }
            else if(this.os.contains("nux")||this.os.contains("nix")||this.os.contains("mac")){
                process = this.runtime.exec("shutdown -h $(expr "+Integer.toString(time)+" / 60)");
            }
            else{
                System.out.println("Unsupported operating system");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void Logout(){
        try {
            Process process;
            int exitcode = -1; // Exit code for checking whether Shutdown is successful
            if(this.os.contains("win")) {
                process = this.runtime.exec("shutdown -s -f -t 0");
                exitcode = process.waitFor();
            }
            else if(this.os.contains("nux")||this.os.contains("nix")||this.os.contains("mac")){
                process = this.runtime.exec("shutdown -h now");
                exitcode = process.waitFor();
            }

            if (exitcode == 0) {
                System.out.println("Log out successfully");
            }else if(exitcode == -1){
                System.out.println("Unsupported operating system");
            } else {
                System.out.println("Log out fail. Exit code: "+exitcode);
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public static void main(String[] arg){
        ShutandLog shutandLog = new ShutandLog();
        shutandLog.Logout();
    }

}
