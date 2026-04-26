#!/bin/sh

kafka-topics --create --topic raw-flight-events --bootstrap-server kafka:9092 --partitions 3 --replication-factor 1 || true