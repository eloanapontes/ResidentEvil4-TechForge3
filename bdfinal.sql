CREATE TABLE Jogador (
    ID_Jogador INT PRIMARY key not null AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Inventario_ID INT,
    cena_atual int
   );



CREATE TABLE Cena (
    ID_Cena INT not null PRIMARY key AUTO_INCREMENT,
    Descricao VARCHAR(500),
    Status ENUM('completa', 'incompleta') NOT NULL
);


CREATE TABLE Escolha (
    ID_Escolha INT PRIMARY key not null AUTO_INCREMENT,
    Descricao VARCHAR(500),
    Resultado ENUM('reset', 'loop', 'sucesso') NOT NULL,
    Cena_ID INT,
    CONSTRAINT fk_cena_escolha FOREIGN KEY (Cena_ID) REFERENCES Cena(ID_Cena)
);



CREATE TABLE Item (
	id_item int not null primary key auto_increment,
	nome varchar(255),
	descricao_positiva varchar(500),
	descricao_negativa varchar(500),
	idCenaAtual int,
);
   

   
   
CREATE TABLE inventario (
    ID_Inventario INT PRIMARY KEY AUTO_INCREMENT,
    ID_Jogador INT,
    ID_Item INT,
    FOREIGN KEY (ID_Jogador) REFERENCES Jogador(ID_Jogador),
    FOREIGN KEY (ID_Item) REFERENCES Item(ID_Item)
);

CREATE TABLE itens_inventario (
    ID_Inventario INT,
    ID_Item INT,
    FOREIGN KEY (ID_Inventario) REFERENCES inventario(ID_Inventario),
    FOREIGN KEY (ID_Item) REFERENCES Item(ID_Item)
);

/*INSERTS DAS CENAS*/
   
insert into cena (ID_Cena, Descricao)
values (1, ' Leon precisa encontrar uma maneira de passar pela vila sem alertar os Ganados:');

insert into cena (ID_Cena, Descricao)
values (2, ' Leon precisa encontrar a chave para a Igreja no cemitério, mas o local está repleto de armadilhas e inimigos.');

insert into cena (ID_Cena, Descricao)
values (3, ' Leon chega ao portão da igreja, que está trancado, mas precisa encontrar uma forma de entrar.');

insert into cena (ID_Cena, Descricao)
values (4, 'Leon finalmente encontra Ashley na igreja, mas há uma armadilha preparada. Escolha sabiamente!');

insert into cena (ID_Cena, Descricao)
values (5, 'Após resgatar Ashley, Leon e ela precisam escapar da igreja, mas os Ganados e uma ameaça maior aguardam do lado de fora');
  

/*INSERTS DOS ITENS*/

insert into Item (ID_Item, nome, descricao)
values (1, 'Chave', 'Chave utilizada para abrir a porta da igreja')


insert into Item (ID_Item, nome, descricao)
values (2, 'Dinamite', 'Um rolo de meia dúzia de bastões de dinamite, tradicionalmente usado em mineração para remover grandes obstáculos.')

insert into Item (ID_Item, nome, descricao)
values (3, 'Erva Verde', 'A mais útil das três ervas que você pode encontrar. A Erva Verde por si só restaurará uma pequena quantidade de saúde,
mas esse efeito pode ser aprimorado ao combiná-la com a Erva Vermelha para criar as Ervas Mistas (G+R) .')

insert into Item (ID_Item, nome, descricao)
values (4, 'Erva Amarela', 'Esta erva pode ser usada para aumentar sua saúde máxima, permitindo que você tome mais dano sem ser morto. Se você combinar
isso com a Red Herb e a Green Herb , ela aumentará sua saúde máxima e restaurará sua saúde completamente.')

insert into Item (ID_Item, nome, descricao)
values (5, 'Mix de Ervas', 'Esta mistura restaurará a mesma quantidade de saúde que uma Green Herb, bem como aumentará sua quantidade máxima de saúde.')

  
ALTER TABLE Item
ADD COLUMN descricao_positiva VARCHAR(500),
ADD COLUMN descricao_negativa VARCHAR(500);
);



alter table item 
change column cena_atual idCenaAtual int;

alter table item 
add column cena_atual int;

select * from item where ID_Item = 1;

UPDATE item SET descricaoPositiva = 'Usar chave!' WHERE id_item = 1;
UPDATE item SET descricaoNegativa = 'Descartar chave' WHERE id_item = 1;
UPDATE item SET cena_atual = 3 WHERE id_item = 1;



 create table saves (
	id_save int primary key auto_increment,
	id_cena_atual int not null,
	foreign key (id_cena_atual) references cena(id_cena)
)

UPDATE Item SET idCenaAtual = 1 WHERE id_item = 1;  
UPDATE Item SET idCenaAtual = 2 WHERE id_item = 2; 
UPDATE Item SET idCenaAtual = 3 WHERE id_item = 3;  
UPDATE Item SET idCenaAtual = 4 WHERE id_item = 4;
UPDATE Item SET idCenaAtual = 5 WHERE id_item = 5; 


INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Avançar pela vila sileciosamente sem chamar a atenção', 'sucesso', 1);
INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Avançar atacando os moradores', 'loop', 1);


INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Buscar a chave no cemitério', 'sucesso', 2);
INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Ignorar o cemitério', 'reset', 2);


INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Tentar arrombar a porta', 'sucesso', 3);
INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Chamar por ajuda', 'loop', 3);


INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Atacar a armadilha', 'sucesso', 4);
INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Desviar da armadilha', 'reset', 4);


INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Sair pela porta da frente', 'sucesso', 5);
INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES ('Voltar e se esconder', 'loop', 5);


create table saves (
	id_save int primary key,
	id_cena_atual int not null,
	foreign key (id_cena_atual) references cena(id_cena)
);


select * from escolha

DELETE FROM Escolha WHERE ID_Escolha = 18;


select * from escolha
#UPDATES DAS ESCOLHAS
update Escolha set Descricao = "Leon decide cuidadosamente se infiltrar e passar despercebido pelos aldeões" where ID_Escolha = 1;
update Escolha set Descricao = "Tenta atacar os aldeões e avançar chamando atenção" where ID_Escolha = 2;

update Escolha set Descricao = "Leon procura cuidadosamente entre os túmulos e encontra a chave da igreja e avança
para a próxima cena" where ID_Escolha = 3;

update Escolha set Descricao = "Correr diretamente para o mausoléu no centro do cemitério" where ID_Escolha = 4;

update Escolha set Descricao = "Utilizar a chave encontrada no cemitério" where ID_Escolha = 5;
update Escolha set Descricao = "Tentar arrombar a porta" where ID_Escolha = 6;

update Escolha set Descricao = "Desarmar a armadilha antes de resgatar Ashley" where ID_Escolha =11;
update Escolha set Descricao = "Ignorar a armadilha e tentar resgatar Ashley mesmo assim" where ID_Escolha =12;

update Escolha set Descricao = "Fugir pela rota segura através do cemitério. Leon escolhe uma rota mais longa, mas
mais segura, passando pelo cemitério onde ele derrotou inimigos anteriormente." where ID_Escolha =13;

update Escolha set Descricao = "Correr direto pelo portão principal da igreja.." where ID_Escolha =14;


SELECT * FROM item WHERE idCenaAtual = 3;

update Item set idCenaAtual = 2 where idCenaAtual =1;

select * from cena c;

select * from saves;

delete from saves;


  