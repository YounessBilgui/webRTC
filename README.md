# WebRTC Mesh Platform

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/technologies/downloads/#java21)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-brightgreen)](https://spring.io/projects/spring-boot)

## 📋 Overview

WebRTC Mesh Platform is a decentralized real-time communication system built on WebRTC for peer-to-peer audio, video, and data sharing directly between browsers. By using a mesh network topology, the application minimizes server dependency while maximizing privacy and performance.

## ✨ Features

### Core Functionality
- **Peer-to-Peer Video Conferencing**
  - Multi-party video/audio calls with adaptive quality
  - Screen sharing and remote presentation capabilities
  - Background blur/replacement with local processing

### Advanced Features
- **Distributed Document Collaboration**
  - Real-time collaborative editing using CRDTs
  - P2P synchronization of document changes
  - Offline editing with seamless reintegration

- **Secure File Sharing**
  - Direct P2P file transfers without server storage
  - Progressive file loading for large media
  - End-to-end encrypted transfers

- **Mesh Network Visualization**
  - Interactive view of the connection topology
  - Connection quality metrics and diagnostics
  - Automatic topology optimization

## 🚀 Tech Stack

### Backend
- Java 21
- Spring Boot 3.2.3
- Spring Security with JWT
- Spring WebSocket for signaling
- Spring Data JPA
- H2 Database (dev) / PostgreSQL (prod)
- Project Lombok

### Frontend
- React.js with Hooks
- WebRTC APIs
- STOMP.js for WebSocket communication
- Material-UI for responsive design
- Redux for state management

### DevOps
- Docker & Docker Compose
- NGINX for reverse proxy and static serving
- GitHub Actions for CI/CD

## 🛠️ Installation

### Prerequisites
- Java 21 or higher
- Node.js 16 or higher
- Maven 3.8 or higher
- Docker and Docker Compose (optional, for containerized deployment)

### Development Setup

#### Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/YounessBilgui/webRTC.git
   cd webRTC.git
   ```

2. Build and run the Spring Boot application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will be available at `http://localhost:8080`

#### Frontend

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```
   The frontend will be available at `http://localhost:3000`

### Docker Deployment

1. Build and run with Docker Compose:
   ```bash
   docker-compose up -d --build
   ```
   The application will be available at `http://localhost`

## 📐 Architecture

### System Components

```
┌─────────────────┐     ┌─────────────────┐
│    Browser A    │◄────►│    Browser B    │
└────────┬────────┘     └────────┬────────┘
         │                       │
         │                       │
         │      ┌─────────┐      │
         └─────►│Signaling│◄─────┘
                │ Server  │
                └─────────┘
```

- **Signaling Server**: Handles initial connection setup and facilitates peer discovery
- **WebRTC Peers**: Direct browser-to-browser connections for media and data
- **Mesh Network**: Dynamically optimized peer connections based on network conditions

### Data Flow

1. **Session Establishment**:
   - User creates or joins a room via the Spring Boot backend
   - WebSocket connection established for signaling

2. **Peer Discovery**:
   - Server broadcasts new participant to existing room members
   - Each peer initiates WebRTC connection process

3. **Media Exchange**:
   - Direct P2P media streaming without server relay (when possible)
   - TURN server fallback for challenging NAT scenarios

4. **Connection Monitoring**:
   - Quality metrics logged to the server
   - Topology adjustments based on network conditions

## 🧪 API Reference

### REST Endpoints

| Method | Endpoint                 | Description                     |
|--------|--------------------------|----------------------------------|
| POST   | /api/auth/login          | Authenticate user               |
| POST   | /api/auth/register       | Register new user               |
| GET    | /api/rooms               | Get all public rooms            |
| POST   | /api/rooms               | Create a new room               |
| GET    | /api/rooms/{roomId}      | Get room details                |
| PUT    | /api/rooms/{roomId}      | Update room details             |
| DELETE | /api/rooms/{roomId}      | Delete a room                   |
| POST   | /api/rooms/{roomId}/join | Join a room                     |

### WebSocket Topics

| Topic                             | Direction | Description                        |
|-----------------------------------|-----------|------------------------------------|
| /app/room/{roomId}/join           | Client → Server | Join a room                 |
| /app/room/{roomId}/leave          | Client → Server | Leave a room                |
| /app/room/{roomId}/offer          | Client → Server | Send WebRTC offer           |
| /app/room/{roomId}/answer         | Client → Server | Send WebRTC answer          |
| /app/room/{roomId}/ice-candidate  | Client → Server | Send ICE candidate          |
| /topic/room/{roomId}/user-joined  | Server → Client | Notification of new user    |
| /topic/room/{roomId}/user-left    | Server → Client | Notification of user leaving|
| /user/queue/session-description   | Server → Client | Receive session description |
| /user/queue/ice-candidate         | Server → Client | Receive ICE candidate       |

## 🛡️ Security

- JWT-based authentication for API and WebSocket connections
- HTTPS enforced in production
- End-to-end encryption for peer communications
- Access control for room permissions
- Input validation and protection against WebRTC exploits

## 📋 Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add some amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request


## 🙏 Acknowledgements

- [WebRTC.org](https://webrtc.org/) - For the powerful real-time communication technology
- [Spring Framework](https://spring.io/) - For the robust backend framework
- [React](https://reactjs.org/) - For the flexible frontend library

---


