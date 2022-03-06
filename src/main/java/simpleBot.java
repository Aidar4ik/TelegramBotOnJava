import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class simpleBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "dordoiplaz_bot";
    }

    @Override
    public String getBotToken() {
        return "5221870523:AAH12yhoU-QnrELDVwWeSYAnSQ8OJ5caB4w";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        if(command.equals("/start")){
            String message = "Этот бот предназначен для добавление товаров"+"\n"+
                    "Вот несколько комманд для добавления:"+"\n"+
                    "1./Добавить\n2./Удалить";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> list = new ArrayList<>();
            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardRow keyboardRow2 = new KeyboardRow();
            KeyboardButton button = new KeyboardButton();
            KeyboardButton button2 = new KeyboardButton();
            button.setText("Добавить");
            button2.setText("Удалить");
            keyboardRow.add(button);
            keyboardRow2.add(button2);
            list.add(keyboardRow);
            list.add(keyboardRow2);
            replyKeyboardMarkup.setKeyboard(list);

            response.setReplyMarkup(replyKeyboardMarkup);
            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if(command.equals("Добавить")){
            String nameOfCompany;
            String categoryOfCompany;
            String priceOfCategory;

            String message = "Заполните поля чтобы добавить товар\n";
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText(message);

            nameOfCompany = update.getMessage().getText();

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
