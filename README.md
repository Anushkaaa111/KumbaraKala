# 🏺 Kumbara-Kala

### Legacy Branding App for Rural Artisans

Kumbara-Kala is an offline-first Android application built to empower traditional potters and rural artisans through simple digital branding tools. The app helps artisans showcase the health, eco-friendly, and cultural benefits of clay products using visually attractive story cards that can be instantly shared through WhatsApp and other applications.

The project focuses on blending traditional craftsmanship with modern digital storytelling while maintaining a lightweight, elegant, and internet-free user experience.

---

# ✨ Features

## 📦 Product Catalog

* Displays 12 bundled clay products
* Includes placeholder vector artwork
* Offline access to product details

## 📝 Story Generator

* Select a product
* Choose predefined benefit templates
* Generate attractive digital story cards

## 👤 Artisan Profile

* Stores artisan details locally
* Includes artisan name, bio, and heritage
* Data persistence using Android DataStore

## 🎨 Card Generation

* Uses Android Canvas APIs
* Creates bitmap-based visual cards
* Saves generated images locally

## 📤 Share Module

* One-tap sharing support
* Share through WhatsApp or any installed app
* Uses FileProvider for secure sharing

---

# 🏗️ Architecture

The application follows a **Single Activity Architecture** using **Navigation Compose** for smooth and modern Android navigation.

```text
User → Catalog → Story Generator → Artisan Profile → Card Generation → Share Module
```

---

# 🛠️ Tech Stack

| Technology          | Purpose                   |
| ------------------- | ------------------------- |
| Kotlin              | Main programming language |
| Jetpack Compose     | Modern UI development     |
| Navigation Compose  | Screen navigation         |
| Android DataStore   | Local data persistence    |
| Android Canvas APIs | Bitmap card generation    |
| FileProvider        | Secure image sharing      |

---

# 📱 Screens Included

* Home Screen
* Product Catalog
* Benefit Story Generator
* Artisan Profile
* Generated Card Preview
* Share Screen

---

# 📂 Project Structure

```text
app/
 ┣ ui/
 ┣ navigation/
 ┣ datastore/
 ┣ storygenerator/
 ┣ cardgenerator/
 ┣ sharemodule/
 ┗ assets/
```

---

# 🎯 Objectives

* Promote eco-friendly clay products
* Help rural artisans with digital branding
* Create awareness about healthy living
* Build a fully offline Android solution
* Encourage cultural and traditional craftsmanship

---

# 📸 Output

The app generates visually appealing digital benefit cards that can be shared instantly across social platforms and messaging applications.

---

# 🔮 Future Enhancements

* Multi-language support
* Real artisan marketplace integration
* AI-generated promotional captions
* Cloud backup support
* QR-based artisan identity system

---

## 👨‍💻 Developed By

**Anushka Tiwari**  
Electronics Engineering  
Cambridge Institute of Technology
