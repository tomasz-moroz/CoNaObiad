package pl.conaobiad.dto;
import pl.conaobiad.model.Message;

public class MessageDto {

    private Long id;
    private String message;

    public static MessageDto messageToDto(Message message) {
        return new MessageDto(message.getId() ,message.getMessage());
    }

    public static Message dtoToMessage(MessageDto messageDto) {
        return new Message(messageDto.getId(), messageDto.getMessage());
    }

    public MessageDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public MessageDto() {
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
        return "MessageDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
