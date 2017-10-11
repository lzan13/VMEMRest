package com.vmloft.develop.java.emrest;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Notification;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by lzan13 on 2017/9/15.
 */
public class VMGCMPush {
    private static Logger logger = LoggerFactory.getLogger(VMGCMPush.class);

    private String apiKey = "AIzaSyDC4442EXi95FwxIJ_pHkpVGzDlHWjrLXA";
    private String regId = "APA91bGDEI_zfXoTXLl_BQVDT1otrUt8_fGXbCu139r1ezpkhyPXFN140pHUL65mb9g6TyFLItMLR00dvenHT-A5hx-enV9I2Z-_aE8di85HTeXA__RXbJdB-X-Vj_i_ZLPhd9oUQ_--Wi5DBYAPheOKpH5DB-rLCg";
    private Sender sender;

    public static void main(String[] args) {
        new VMGCMPush().sendGCMMessage();
    }

    public void sendGCMMessage() {
        sender = new Sender(apiKey);
        Message.Builder messageBuilder = new Message.Builder();
        messageBuilder.addData("alert", "hello gcm!");

        Notification.Builder notificationBuilder = new Notification.Builder("");
        notificationBuilder.body("hello gcm notication!");
        messageBuilder.notification(notificationBuilder.build());
        try {
            Result result = sender.send(messageBuilder.build(), regId, 1);
            logger.info(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
