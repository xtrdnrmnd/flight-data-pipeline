package com.xtrdnrmnd.flightpipeline

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.syntax.EncoderOps
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import java.time.Instant
import java.util.Properties

object KafkaProducer extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:29092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val flEvent = FlightEvent("ABC123", "Lufthansa", None, None, Instant.now)

  val record = new ProducerRecord[String, String](
    "raw-flight-events", "ABC123", flEvent.asJson.noSpaces
  )

  producer.send(record, (metadata, exception) => {
    if (exception != null)
      println(s"FAILED: ${exception.getMessage}")
    else
      println(s"SUCCESS: ${metadata.topic()} ${metadata.offset()}")
  })

  producer.flush()

  producer.close()

}
