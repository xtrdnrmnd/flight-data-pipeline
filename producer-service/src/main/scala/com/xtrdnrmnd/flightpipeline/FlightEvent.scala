package com.xtrdnrmnd.flightpipeline

import java.time.Instant

case class FlightEvent(
  flightId: String,
  airline: String,
  from: Option[String],
  to: Option[String],
  timestamp: Instant
)
