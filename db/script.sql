-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema carfire
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carfire
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carfire` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `carfire` ;

-- -----------------------------------------------------
-- Table `carfire`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sigla` CHAR(1) NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`veiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `grupo_id` INT NOT NULL,
  `chassi` VARCHAR(45) NULL,
  `placa` VARCHAR(45) NULL,
  `km` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `fabricante` VARCHAR(45) NULL,
  `tarifa` VARCHAR(45) NULL,
  `taxa` VARCHAR(45) NULL,
  `combustivel` VARCHAR(45) NULL,
  `portas` INT(1) NULL,
  `ano_modelo` INT(4) NULL,
  `cor` VARCHAR(45) NULL,
  `renavam` VARCHAR(45) NULL,
  `descricao` VARCHAR(100) NULL,
  `disponivel` TINYINT(1) NULL,
  `estoque` VARCHAR(45) NULL,
  `observacoes` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_veiculo_grupo_veiculo1_idx` (`grupo_id` ASC),
  CONSTRAINT `fk_veiculo_grupo_veiculo1`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `carfire`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`cliente_pf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`cliente_pf` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `cpf` BIGINT(11) NULL,
  `nome` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `habilitacao` VARCHAR(45) NULL,
  `data_nascimento` VARCHAR(45) NULL,
  `genero` CHAR(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`cliente_pj`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`cliente_pj` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `cnpj` BIGINT(14) NULL,
  `razao_social` VARCHAR(45) NULL,
  `nome_comercial` VARCHAR(45) NULL,
  `inscricao_estadual` VARCHAR(45) NULL,
  `data_fundacao` VARCHAR(45) NULL,
  `numero_funcionarios` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`agencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cidade_id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agencia_cidade1_idx` (`cidade_id` ASC),
  CONSTRAINT `fk_agencia_cidade1`
    FOREIGN KEY (`cidade_id`)
    REFERENCES `carfire`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`devolucao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`devolucao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agencia_id` INT NULL,
  `data` VARCHAR(45) NULL,
  `hora` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_devolucao_agencia1_idx` (`agencia_id` ASC),
  CONSTRAINT `fk_devolucao_agencia1`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `carfire`.`agencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`emprestimo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agencia_id` INT NOT NULL,
  `pagamento_id` INT NULL,
  `devolucao_id` INT NULL,
  `reserva_id` INT NULL,
  `cliente_pf_id` INT NULL,
  `cliente_pj_id` INT NULL,
  `data` VARCHAR(45) NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emprestimo_pagamento1_idx` (`pagamento_id` ASC),
  INDEX `fk_emprestimo_cliente_pj1_idx` (`cliente_pj_id` ASC),
  INDEX `fk_emprestimo_pj_devolucao1_idx` (`devolucao_id` ASC),
  INDEX `fk_emprestimo_pj_reserva1_idx` (`reserva_id` ASC),
  INDEX `fk_emprestimo_cliente_pf1_idx` (`cliente_pf_id` ASC),
  INDEX `fk_emprestimo_agencia1_idx` (`agencia_id` ASC),
  CONSTRAINT `fk_emprestimo_pagamento1`
    FOREIGN KEY (`pagamento_id`)
    REFERENCES `carfire`.`pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_cliente_pj1`
    FOREIGN KEY (`cliente_pj_id`)
    REFERENCES `carfire`.`cliente_pj` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_pj_devolucao1`
    FOREIGN KEY (`devolucao_id`)
    REFERENCES `carfire`.`devolucao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_pj_reserva1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `carfire`.`reserva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_cliente_pf1`
    FOREIGN KEY (`cliente_pf_id`)
    REFERENCES `carfire`.`cliente_pf` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_agencia1`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `carfire`.`agencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`itens_emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`itens_emprestimo` (
  `emprestimo_id` INT NOT NULL,
  `veiculo_id` INT NOT NULL,
  INDEX `fk_itens_emprestimo_veiculo1_idx` (`veiculo_id` ASC),
  INDEX `fk_itens_emprestimo_emprestimo_pj1_idx` (`emprestimo_id` ASC),
  CONSTRAINT `fk_itens_emprestimo_veiculo1`
    FOREIGN KEY (`veiculo_id`)
    REFERENCES `carfire`.`veiculo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_emprestimo_emprestimo_pj1`
    FOREIGN KEY (`emprestimo_id`)
    REFERENCES `carfire`.`emprestimo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agencia_id` INT NULL,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_agencia1_idx` (`agencia_id` ASC),
  CONSTRAINT `fk_usuario_agencia1`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `carfire`.`agencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`tarifa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`itens_tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`itens_tarifa` (
  `grupo_id` INT NOT NULL,
  `tarifa_id` INT NOT NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`grupo_id`, `tarifa_id`),
  INDEX `fk_grupo_has_tarifa_tarifa1_idx` (`tarifa_id` ASC),
  INDEX `fk_grupo_has_tarifa_grupo1_idx` (`grupo_id` ASC),
  CONSTRAINT `fk_grupo_has_tarifa_grupo1`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `carfire`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_has_tarifa_tarifa1`
    FOREIGN KEY (`tarifa_id`)
    REFERENCES `carfire`.`tarifa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`acessorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`acessorio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carfire`.`itens_acessorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carfire`.`itens_acessorio` (
  `emprestimo_id` INT NOT NULL,
  `acessorio_id` INT NOT NULL,
  PRIMARY KEY (`emprestimo_id`, `acessorio_id`),
  INDEX `fk_emprestimo_has_acessorio_acessorio1_idx` (`acessorio_id` ASC),
  INDEX `fk_emprestimo_has_acessorio_emprestimo1_idx` (`emprestimo_id` ASC),
  CONSTRAINT `fk_emprestimo_has_acessorio_emprestimo1`
    FOREIGN KEY (`emprestimo_id`)
    REFERENCES `carfire`.`emprestimo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_has_acessorio_acessorio1`
    FOREIGN KEY (`acessorio_id`)
    REFERENCES `carfire`.`acessorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Dados para produção
-- -----------------------------------------------------
insert into `carfire`.`usuario`(nome, email, senha) values
("Gabriel", "gabriel@provedor.com", "123");

insert into cliente_pf (email, nome, genero) values
("gabriel@provedor.com", "Gabriel Freire Braz", "M"),
("maria@provedor.com", "Maria da Silva", "F");

insert into `carfire`.`grupo`(sigla, nome) values
("A", "A – Econômico"),
("C", "C – Econômico com Ar"),
("F", "F – Intermediário"),
("G", "G – Intermediário Wagon Especial"),
("H", "H – Executivo"),
("I", "I – Utilitário"),
("K", "K – Executivo Luxo"),
("M", "M – Intermediário Wagon"),
("N", "N – Pick-up"),
("P", "P – 4 x 4 Especial"),
("R", "R – Minivan"),
("U", "U – Furgão"),
("Y", "Y – Blindado");	

insert into `carfire`.`acessorio`(nome) values
("Navegador GPS"),
("Cadeira de Bebê"),
("Motorista");

insert into `carfire`.`tarifa`(nome) values
("DIÁRIA KM LIVRE"),
("KM CONTROLADO (VALOR DIÁRIO)");

insert into `carfire`.`itens_tarifa`(grupo_id, tarifa_id, descricao) values
(1, 1, "R$ 32,90"),
(2, 1, "R$ 37,90"),
(3, 1, "R$ 35,90"),
(4, 1, "R$ 99,90"),
(5, 1, "R$ 59,90"),
(6, 1, "R$ 49,99"),
(7, 1, "R$ 49,99"),
(8, 1, "R$ 49,99"),
(9, 1, "R$ 67,99"),
(10, 1, "R$ 49,99"),
(11, 1, "R$ 69,99"),
(12, 1, "R$ 79,99"),
(13, 1, "R$ 119,90"),
(1, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(2, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(3, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(4, 2, "R$ 69,99 + R$ 0,99 por km rodado."),
(5, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(6, 2, "R$ 85,99 + R$ 2,39 por km rodado."),
(7, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(8, 2, "R$ 39,99 + R$ 0,69 por km rodado."),
(9, 2, "R$ 39,99 + R$ 0,85 por km rodado."),
(10, 2, "R$ 39,99 + R$ 0,89 por km rodado."),
(11, 2, "R$ 45,69 + R$ 1,49 por km rodado."),
(12, 2, "R$ 39,99 + R$ 0,49 por km rodado."),
(13, 2, "R$ 90,49 + R$ 4,16 por km rodado.");

insert into `carfire`.`cidade`(nome) values
("Taboão da Serra - SP"),
("Pinheiros - SP"),
("Lapa - SP"),
("Rio de Janeiro - RJ"),
("Copacabana - RJ"),
("Belo Horizonte - MG");

insert into `carfire`.`agencia`(cidade_id, nome) values
(2, "Agência do largo"),
(2, "Agência do faria lima"),
(5, "Agência da praia"),
(4, "Agência da pesada"),
(6, "Agência mineira");

INSERT INTO emprestimo (agencia_id, pagamento_id, devolucao_id, reserva_id, cliente_pf_id, cliente_pj_id, data, hora, status) VALUES 
(1, NULL, NULL, NULL, 1, NULL, "02-11-2014", "15:00", "emprestado"),
(2, NULL, NULL, NULL, 2, NULL, "02-11-2014", "15:00", "cancelado"),
(3, NULL, NULL, NULL, 1, NULL, "02-11-2014", "15:00", "finalizado"),
(2, NULL, NULL, NULL, 2, NULL, "02-11-2014", "15:00", "emprestado");
