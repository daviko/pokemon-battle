INSERT INTO PLAYERS (id, name) VALUES
(1, 'Ash Ketchum'),
(2, 'Gary Oak');

INSERT INTO ATTACK (id, name, text, damage) VALUES
(1, 'Thunderbolt', 'Deals heavy electric damage.', 90),
(2, 'Vine Whip', 'Whips the opponent with vines.', 45),
(3, 'Hydro Pump', 'Blasts water at high pressure.', 110),
(4, 'Flamethrower', 'Breathes intense flames.', 90),
(5, 'Quick Attack', 'Strikes first with quick speed.', 40),
(6, 'Hyper Beam', 'Releases a powerful energy beam.', 120),
(7, 'Solar Beam', 'Absorbs light and releases energy.', 100),
(8, 'Ice Beam', 'Shoots a beam of icy cold energy.', 90),
(9, 'Earthquake', 'Causes a massive tremor.', 100),
(10, 'Dragon Rage', 'Unleashes a dragons fury.', 60);

INSERT INTO POKEMON (id, name, hp, attack_id, player_id) VALUES
('xy7-54', 'Pikachu', 60, 1, 1),
('xy7-2', 'Bulbasaur', 50, 2, 1),
('xy7-22', 'Blastoise', 150, 3, 2),
('xy7-56', 'Charizard', 150, 4, 2),
('xy7-67', 'Pidgey', 40, 5, 1),
('xy7-99', 'Gyarados', 130, 6, 2),
('xy7-100', 'Venusaur', 160, 7, 1),
('xy7-76', 'Articuno', 120, 8, 2),
('xy7-81', 'Onix', 90, 9, 1),
('xy7-93', 'Dragonite', 160, 10, 2);

INSERT INTO BATTLE_RESULTS (id, final_hp_pokemon1, final_hp_pokemon2, winner) VALUES
(1, 0, 50, 'Gary Oak'),
(2, 100, 0, 'Ash Ketchum'),
(3, 0, 30, 'Gary Oak'),
(4, 60, 0, 'Ash Ketchum'),
(5, 0, 90, 'Gary Oak'),
(6, 50, 0, 'Ash Ketchum'),
(7, 0, 40, 'Gary Oak'),
(8, 100, 0, 'Ash Ketchum'),
(9, 0, 120, 'Gary Oak'),
(10, 60, 0, 'Ash Ketchum');

INSERT INTO player_battle (player_id, battle_id) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 2),
(1, 3),
(2, 3),
(1, 4),
(2, 4),
(1, 5),
(2, 5),
(1, 6),
(2, 6),
(1, 7),
(2, 7),
(1, 8),
(2, 8),
(1, 9),
(2, 9),
(1, 10),
(2, 10);

INSERT INTO pokemon_battle (pokemon_id, battle_id) VALUES
('xy7-54', 1),
('xy7-2', 1),
('xy7-22', 2),
('xy7-56', 2),
('xy7-67', 3),
('xy7-99', 3),
('xy7-100', 4),
('xy7-76', 4),
('xy7-81', 5),
('xy7-93', 5),
('xy7-54', 6),
('xy7-2', 6),
('xy7-22', 7),
('xy7-56', 7),
('xy7-67', 8),
('xy7-99', 8),
('xy7-100', 9),
('xy7-76', 9),
('xy7-81', 10),
('xy7-93', 10);
