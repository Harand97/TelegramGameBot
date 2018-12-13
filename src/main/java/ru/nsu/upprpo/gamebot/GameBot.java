package ru.nsu.upprpo.gamebot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class GameBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var messageText = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();

            var message = new SendMessage()
                    .setChatId(chatId)
                    .setText(messageText);

            try {
                execute(message);
            } catch (TelegramApiException exception) {
                exception.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "@games7997_bot";
    }

    @Override
    public String getBotToken() {
        return "741414908:AAFBibXBwqWtfbkKRi0Dw6EHbDLrVLJ7U6c";
    }
}
