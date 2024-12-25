package com.gasparbarancelli;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subscriber implements MqttCallback {

    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String TOPIC = "test/topic";
    private static final String CLIENT_ID = "SubscriberExample";

    public static void main(String[] args) {
        new Subscriber().startSubscriber();
    }

    public void startSubscriber() {
        try {
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID, new MemoryPersistence());
            client.setCallback(this);
            client.connect();
            client.subscribe(TOPIC, 1);
            System.out.println("Assinado no tópico: " + TOPIC);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Conexão perdida! Causa: " + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Mensagem recebida. Tópico: " + topic +
                           ", Mensagem: " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Chamado quando a publicação é confirmada
    }
}
