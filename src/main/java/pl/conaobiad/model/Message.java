package pl.conaobiad.model;

import lombok.*;

import javax.persistence.*;

@NamedQuery(
        name = Message.GET_MESSAGE,
        query = "SELECT m FROM Message m"
)

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class Message {

    public static final String GET_MESSAGE = "Message.getMessage";

    @Id
    @Column
    private Long id;

    @Column
    private String message;
}
