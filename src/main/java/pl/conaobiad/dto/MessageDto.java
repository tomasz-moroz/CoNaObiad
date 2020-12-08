package pl.conaobiad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.conaobiad.model.Message;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;
    private String message;

    public static MessageDto messageToDto(Message message) {
        return new MessageDto(message.getId() ,message.getMessage());
    }

    public static Message dtoToMessage(MessageDto messageDto) {
        return new Message(messageDto.getId(), messageDto.getMessage());
    }
}
