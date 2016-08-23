package com.telegram.quest.bot.sender;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.request.SendMessage;

public class TelegramMessageSender implements TelegramMessageSendable {
    private static final String DEFAULT_CHAT_ID = "-154460024";
    private static final String DEFAULT_BOT_TOKEN = "246460833:AAG9-Bw1wFxxWaCE6WdEJ_td6EsXZmjQP_Q";
    private TelegramBot bot;
    private String chatId;

    public TelegramMessageSender(String chatId) {
        this.chatId = chatId;
        bot = TelegramBotAdapter.build(DEFAULT_BOT_TOKEN);
    }

    public TelegramMessageSender() {
        this(DEFAULT_CHAT_ID);
    }

    public void send(String message) {
        bot.execute(new SendMessage(chatId, message));
    }
}