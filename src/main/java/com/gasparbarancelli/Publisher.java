package com.gasparbarancelli;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Publisher {

    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String TOPIC = "test/topic";
    private static final String CLIENT_ID = "PublisherExample";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID, new MemoryPersistence());
            client.connect();

            String mensagem = args.length == 0 ? "Olá! Mensagem de teste via MQTT." : args[0];
            MqttMessage mqttMessage = new MqttMessage(mensagem.getBytes());
            mqttMessage.setQos(1);

            client.publish(TOPIC, mqttMessage);
            System.out.println("Mensagem publicada: " + mensagem);

            client.disconnect();
            client.close();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
