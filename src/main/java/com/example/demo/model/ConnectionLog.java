package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "connection_logs")
@Data
public class ConnectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime connectedAt;

    private LocalDateTime disconnectedAt;

    private String ipAddress;

    private String userAgent;

    @Column(nullable = false)
    private ConnectionType connectionType;

    private Integer connectionQuality;

    private String iceCandidate;

    public enum ConnectionType {
        DIRECT_P2P,
        RELAY_TURN,
        SERVER_FALLBACK
    }
}