SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE post;

INSERT INTO post(`id`, `title`, `body`)
VALUES(1, 'Post one', 'The man who changed the world'),
    (2, 'Post two', 'Considering the challenges'),
    (3, 'Post three', 'He never gave up'),
    (4, 'Post four', 'and he gave his best every step'),
    (5, 'Post five', 'Now the world sings his praise'),

SET FOREIGN_KEY_CHECKS = 1;