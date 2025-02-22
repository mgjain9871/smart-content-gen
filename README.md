# AI-powered Smart Content Generation and Recommendation System for E-learning

## 📌 Project Overview
This project is an **AI-powered adaptive learning platform** designed to enhance personalized learning experiences. It integrates **Java Spring Boot** for the backend and **Generative AI** to dynamically generate educational content, quizzes, and summaries. The system provides an **intelligent learning path** tailored to each user based on their progress and performance.

## 🏗️ Tech Stack
- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **Authentication:** JWT
- **AI Integration:** OpenAI API (for content generation, quiz creation, and summarization)
- **API Documentation:** Swagger

## 🎯 Features
### ✅ User Management
- Register/Login with JWT authentication
- Track user progress and scores

### ✅ AI-Powered Content Generation
- Generate educational content dynamically using OpenAI
- Summarize key concepts for quick learning

### ✅ Intelligent Quiz Generation
- AI-generated quizzes based on content
- Adaptive difficulty level based on user performance

### ✅ Personalized Learning Path
- AI-driven recommendations based on user strengths/weaknesses
- Adaptive assessments to guide progress

---
## 🏛️ High-Level Architecture
### 🖼️ System Components
1. **User Service** → Handles authentication, user profiles, progress tracking.
2. **Content Service** → Manages courses, topics, AI-generated content.
3. **Quiz Service** → AI-generated quizzes based on user’s learning history.
4. **Recommendation Engine** → Personalized learning path using AI.

### 📌 API Workflow
1. **User logs in → Token generated via JWT**
2. **Requests content** → AI dynamically generates explanations
3. **Takes quiz** → AI adapts questions based on performance
4. **Receives recommendations** → AI suggests next topics based on progress

---
## 🚀 Installation & Setup
### 🔧 Prerequisites
- Java 17+
- MySQL
- OpenAI API Key (for AI features)

### 🔥 Run the Project Locally
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/ai-learning-platform.git
   ```
2. Set up environment variables:
   - Create a `.env` file in the root directory and add environment variables.

3. Install dependencies:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```
5. Access API Documentation:
   - Open **`http://localhost:8080/swagger-ui.html`** in your browser

---
## 📡 API Endpoints
### 🔑 Authentication
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/api/auth/register` | Register new users |
| POST   | `/api/auth/login` | Authenticate users & get JWT |

### 📚 Content Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET    | `/api/content/{topicId}` | Fetch AI-generated content |
| POST   | `/api/content/generate` | Generate content dynamically |

### 📝 Quiz Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET    | `/api/quiz/{contentId}` | Fetch AI-generated quiz |
| POST   | `/api/quiz/submit` | Submit answers and get score |

### 🎯 Learning Path Recommendations
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET    | `/api/recommendations` | Fetch AI-based learning suggestions |

---
## 🛠️ Future Enhancements
- 🔹 Add voice-based AI tutor for Q&A
- 🔹 Implement gamification features (badges, leaderboards)
- 🔹 Mobile App version (React Native / Flutter)

---
## 🤝 Contributing
Want to contribute? 🚀
1. Fork the repository
2. Create a feature branch (`git checkout -b feature-name`)
3. Commit changes (`git commit -m "Add feature"`)
4. Push to the branch (`git push origin feature-name`)
5. Submit a Pull Request

---
## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
