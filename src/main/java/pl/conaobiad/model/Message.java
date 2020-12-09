package pl.conaobiad.model;

import javax.persistence.*;

@NamedQuery(
        name = Message.GET_MESSAGE,
        query = "SELECT m FROM Message m"
)

@Table
@Entity
public class Message {

    public static final String GET_MESSAGE = "Message.getMessage";

    @Id
    @Column
    private Long id;

    @Column
    private String message;

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
