# 🍔 Mesen Makanan App

Aplikasi mobile pemesanan makanan *online* (Food Ordering App) yang dibuat menggunakan **Jetpack Compose** untuk antarmuka pengguna modern dan *reactive*. Aplikasi ini mensimulasikan alur pengguna dasar mulai dari pendaftaran hingga konfirmasi pemesanan.

## ✨ Fitur Utama (Features)

* **Pendaftaran & Autentikasi Persisten:** Pengguna dapat mendaftar dan *login*. Data pendaftaran disimpan secara lokal menggunakan **SharedPreferences** (simulasi *database* lokal).
* **Splash Screen:** Layar sambutan awal.
* **Daftar Menu Interaktif:** Menampilkan daftar 10 menu makanan dengan harga yang dapat di-*scroll* (menggunakan `LazyColumn`).
* **Detail Menu:** Navigasi dari daftar menu ke halaman detail item.
* **Alur Pemesanan:** Alur yang mengarahkan pengguna dari pemilihan menu $\rightarrow$ detail alamat $\rightarrow$ konfirmasi $\rightarrow$ sukses.
* **Desain Material 3 (M3):** Menggunakan komponen dan tipografi terbaru dari Jetpack Compose Material 3.

## 💻 Teknologi yang Digunakan (Tech Stack)

* **Bahasa Pemrograman:** Kotlin
* **UI Framework:** Jetpack Compose
* **Navigasi:** Compose Navigation
* **Penyimpanan Lokal:** SharedPreferences (dengan Gson untuk persistensi data `User`)
* **Arsitektur:** Sederhana (Compose Screens & State Hoisting di `MainActivity`)

## 📄 Struktur Proyek

Proyek mengikuti struktur standar Android, di mana semua *screen* utama berada di bawah *package* `activities`.
<img width="1080" height="2400" alt="Screenshot_20251030_120135" src="https://github.com/user-attachments/assets/a9ca3b4d-4d8c-48ae-bcef-b86f30ab79c9" />
