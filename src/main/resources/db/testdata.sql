INSERT INTO CATEGORY (TYPE)
    VALUES
        ('Zawodowe'),
        ('Gospodarcze'),
        ('Nauka'),
        ('Naprawcze'),
        ('Załatwić'),
        ('Coroczne');

INSERT INTO TASK_ENTITY (DESCRIPTION, DATE_OF_SETUP, DEADLINE, CATEGORY_ID)
    VALUES
        ('Wizytacja klienta pod koniec Października', '2022-09-11', '2022-10-25', 1),
        ('Zbiórka starych mebli', '2022-09-12', '2022-10-10', 2),
        ('Zadanie z Bootcamp Java', '2022-09-12', '2022-10-01', 3),
        ('Koniec kurse z Bootcamp Java', '2022-01-12', '2022-10-04', 3),
        ('Przybić listwy przypodłogowe', '2022-03-17', '2022-12-31', 4),
        ('Wymiana klocków hamulcowych w Polonezie', '2022-10-01', '2022-10-14', 5),
        ('Przegląd Poloneza', '2022-04-01', '2023-03-31', 6),
        ('Rocznica ślubu', '2022-01-01', '2023-01-01', 6),
        ('Przegląd kominów', '2022-01-01', '2023-11-01', 6);