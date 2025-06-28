# 🎬 Rate Right

**Rate Right** is a full-stack web application that allows users to manage their movie watchlist by assigning priorities and providing ratings. If a rating seems incorrect or out of sync, the app will automatically adjust it using an internal API.

---

## 📌 Features

- ✅ Add movies with title and priority
- ✏️ Update ratings manually or via auto-correction API
- 📋 Display sorted list of movies based on rating/priority
- 🔍 Validate and correct ratings in real-time
- 🌐 Full-stack implementation using Java Spring Boot + Thymeleaf

---

## 🧱 Tech Stack

| Layer          | Technology                |
|----------------|---------------------------|
| 👨‍💻 Frontend     | HTML, CSS, Thymeleaf        |
| ⚙️ Backend      | Java Spring Boot (REST API) |
| 🗃️ Database     | H2 / MySQL (configurable)  |
| 🧪 Testing      | JUnit, Spring Test         |
| 📦 Build Tool   | Maven                     |

---

## 🧑‍💻 How It Works

1. Users enter a movie name and assign a **priority** (e.g., high, medium, low).
2. Users then provide an initial **rating** (0–10).
3. The system verifies the rating, and if it's outside accepted norms, it adjusts it using an API.
4. All movies are displayed in a sorted format with their corrected ratings.

---

## 🚀 Getting Started

### 📥 Clone the Repo
```bash
git clone https://github.com/your-username/rate-right.git
cd rate-right
