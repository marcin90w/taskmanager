INSERT INTO USER(ID, EMAIL, PASSWORD)
VALUES
    (1, 'masteradmin@byom.de', '{noop}asdf'),
    (2, 'admin@byom.de', '{noop}asdf'),
    (3, 'user@byom.de', '{noop}asdf'),
    (4, 'marcin90w@gmail.com', '{noop}asdf');

INSERT INTO USER_ROLE(USER_ID, ROLE)
VALUES
    (1, 'ROLE_MASTERADMIN'),
    (1, 'ROLE_ADMIN'),
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN'),
    (2, 'ROLE_USER'),
    (3, 'ROLE_USER'),
    (4, 'ROLE_USER');


INSERT INTO CATEGORY (TYPE)
    VALUES
        ('Zawodowe'),
        ('Gospodarcze'),
        ('Nauka'),
        ('Naprawcze'),
        ('Załatwić'),
        ('Coroczne');

INSERT INTO TASK_ENTITY (DESCRIPTION, DATE_OF_SETUP, DEADLINE, CATEGORY_ID, USER_ID)
    VALUES
        ('Wizytacja klienta pod koniec Października', '2022-09-11', '2022-10-25', 1, 1),
        ('Zbiórka starych mebli', '2022-09-12', '2022-10-10', 2, 2),
        ('Zadanie z Bootcamp Java', '2022-09-12', '2022-10-01', 3, 3),
        ('Koniec kurse z Bootcamp Java', '2022-01-12', '2022-10-04', 3, 3),
        ('Przybić listwy przypodłogowe', '2022-03-17', '2022-12-31', 4, 3),
        ('Wymiana klocków hamulcowych w Polonezie', '2022-10-01', '2022-10-14', 5, 3),
        ('Przegląd Poloneza', '2022-04-01', '2023-03-31', 6, 3),
        ('Rocznica ślubu', '2022-01-01', '2023-01-01', 6, 3),
        ('Przegląd kominów', '2022-01-01', '2023-11-01', 6, 4);