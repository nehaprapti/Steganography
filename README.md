
# 🕵️‍♂️ StegoApp - Java Steganography Tool

Welcome to **StegoApp**, a Java-based console application that hides secret messages inside image files using steganography! Perfect for privacy enthusiasts, cryptography learners, and Java developers who love problem-solving with threads, files, and OOP concepts. 💡

## 🚀 Features

- 🔐 **Message Hiding:** Hide plain text within PNG images.
- 🧠 **OOP Design:** Clean, modular Object-Oriented Programming architecture.
- 📂 **File Handling:** Reads and writes both text and image files with ease.
- 🧵 **Multithreading:** Efficient encoding and decoding using Java threads.
- ⚠️ **Robustness:** Full exception handling for reliable performance.

---

## 📸 Demo

Here’s a quick peek at what StegoApp does:

```

Choose an option:

1. Encode message
2. Decode message
   Enter choice: 1
   Enter path to image: input.png
   Enter message to hide: This is top secret!
   Saving encoded image to: output.png
   Done! ✅

```

---

## 🛠️ How It Works

1. **Encoding:**
   - Reads the image.
   - Converts text to binary.
   - Hides bits inside image pixels using LSB (Least Significant Bit) technique.
2. **Decoding:**
   - Extracts hidden bits from the image.
   - Reconstructs and displays the original message.

---

## 📁 Project Structure

```

📂 StegoApp
┣ 📜 StegoApp.java
┗ 📜 README.md

````

---

## 🔧 How to Run

> Prerequisites: Java 8+ installed.

```bash
javac StegoApp.java
java StegoApp
````

---

## 🎯 Learning Objectives

This project is perfect if you're looking to:

* Practice **Java OOP** principles.
* Work with **multithreading and file I/O**.
* Understand **steganography** from the ground up.
* Build console-based Java applications.

---

## 🌟 What's Next?

* [ ] GUI Version using JavaFX or Swing
* [ ] Support for JPEG, BMP
* [ ] Encrypted message support (AES/Password protection)
* [ ] Web-based version using JavaScript/Node.js

---

## 🤝 Contributing

Feel free to fork, star ⭐, and submit PRs! Bug reports and feature suggestions are more than welcome.

---

## 🧠 Fun Fact

Did you know? Steganography was used as early as 440 BC when messages were tattooed on a slave’s shaved head and hidden once the hair grew back! 🤯

---

> Created with 💙 by Neha Prapti
> Made for learning, teaching, and having fun with code.

```
