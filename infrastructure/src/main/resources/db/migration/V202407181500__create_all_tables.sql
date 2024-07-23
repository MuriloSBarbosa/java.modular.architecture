create table user_account (
    id uuid primary key,
    name varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp
);

create table post (
    id uuid primary key,
    title varchar(255) not null,
    content text not null,
    user_account_id uuid not null,
    created_at timestamp not null,
    updated_at timestamp,
    foreign key (user_account_id) references user_account(id)
);