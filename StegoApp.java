import java.io.*;
import java.util.*;

class StegoProcessor {
    private static final String FILE_NAME = "encoded.txt";

    public void encode(String message) throws Exception {
        if (message == null || message.trim().isEmpty())
            throw new Exception("Message cannot be empty!");

        StringBuilder binaryBuilder = new StringBuilder();

        for (char ch : message.toCharArray()) {
            String binaryChar = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
            binaryBuilder.append(binaryChar);
        }

        StringBuilder stegoData = new StringBuilder();
        for (char bit : binaryBuilder.toString().toCharArray()) {
            if (bit == '0') stegoData.append(' ');
            else if (bit == '1') stegoData.append('\t');
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(stegoData.toString());
        }
    }

    public String decode() throws IOException {
        StringBuilder binaryBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch == ' ') binaryBuilder.append('0');
                else if (ch == '\t') binaryBuilder.append('1');
            }
        }

        StringBuilder message = new StringBuilder();
        for (int i = 0; i < binaryBuilder.length(); i += 8) {
            String byteStr = binaryBuilder.substring(i, i + 8);
            int charCode = Integer.parseInt(byteStr, 2);
            message.append((char) charCode);
        }

        return message.toString();
    }
}

class EncodeThread extends Thread {
    private final StegoProcessor processor;
    private final String message;

    public EncodeThread(StegoProcessor processor, String message) {
        this.processor = processor;
        this.message = message;
    }

    public void run() {
        try {
            System.out.println("Encoding message...");
            processor.encode(message);
            Thread.sleep(1000);
            System.out.println("Encoding complete.");
        } catch (Exception e) {
            System.out.println("Encoding error: " + e.getMessage());
        }
    }
}

public class StegoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StegoProcessor processor = new StegoProcessor();

        System.out.print("Enter secret message to encode: ");
        String secret = sc.nextLine();

        EncodeThread encoder = new EncodeThread(processor, secret);
        encoder.start();

        try {
            encoder.join(); 
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.print("Do you want to decode the message? (yes/no): ");
        String choice = sc.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            try {
                String message = processor.decode();
                System.out.println("Decoded message: " + message);
            } catch (IOException e) {
                System.out.println("Decoding error: " + e.getMessage());
            }
        } else {
            System.out.println("Decoding skipped.");
        }

        sc.close();
    }
}
