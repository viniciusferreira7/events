CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS users (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   name VARCHAR(100) NOT NULL,
   email TEXT UNIQUE NOT NUll,
   created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TYPE event_type AS ENUM (
    'CONFERENCE',
    'SEMINAR',
    'WORKSHOP',
    'MEETUP',
    'NETWORKING',
    'LECTURE',
    'WEBINAR',
    'PANEL',
    'TALK',
    'BOOTCAMP',
    'HACKATHON',
    'TRAINING',
    'ROUND_TABLE',
    'SUMMIT',
    'FAIR'
);


CREATE TABLE IF NOT EXISTS events (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sponsor_id UUID NOT NULL,

    identifier VARCHAR(64) UNIQUE NOT NULL,
    type event_type NOT NULL,

    name VARCHAR(300) NOT NULL,
    description VARCHAR(600) NULL,
    location TEXT NOT NULL,
    capacity SMALLINT NULL,


    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NULL,

    FOREIGN KEY(sponsor_id) REFERENCES users(id)
);

CREATE INDEX  idx_events_sponsor_id on events(sponsor_id);