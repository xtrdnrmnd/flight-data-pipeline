## Local Infrastructure

Run everything with:

docker compose -p  flight-data-pipeline up -d

This will:
- start Kafka + ZooKeeper + Kafka UI
- automatically create required topics via init container