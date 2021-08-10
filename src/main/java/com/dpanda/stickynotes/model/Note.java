package com.dpanda.stickynotes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @SequenceGenerator(name = "sticky_notes_sequence", sequenceName = "sticky_notes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "sticky_notes_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10000)
    private String content;

    @Column(nullable = false, updatable = false)
    private Date created;

    @Column(nullable = false)
    private Date modified;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", updatable = false)
    @Getter(AccessLevel.NONE)
    private User user;

    public Note(String title, String content, Date created, Date modified, User user) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.user = user;
    }

    public Long getUserId() {
        return this.user.getId();
    }
}
