package one.digitalinnivation;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinnivation.dominio.Bootcamp;
import one.digitalinnivation.dominio.Conteudo;
import one.digitalinnivation.dominio.Curso;
import one.digitalinnivation.dominio.Dev;
import one.digitalinnivation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJava = new Curso();
		cursoJava.setTitulo("Curso de Java Básico");
		cursoJava.setDescricao("Aprenda os conceitos básicos de Java");
		cursoJava.setCargaHoraria(8);
		
		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("Curso de .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos de .NET");
		cursoDotNet.setCargaHoraria(10);
		
		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Curso de Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados de Java");
		cursoJavaAvancado.setCargaHoraria(12);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientacao a Objetos com Java");
		mentoria.setDescricao("Imersao sobre os principais conceitos de OO");
		mentoria.setData(LocalDateTime.now());
		
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJava, cursoJavaAvancado, cursoDotNet, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);
	
		
		Dev felipe = new Dev();
		felipe.setNome("Felipe");
		
		felipe.inscrever(cursoJava);
		felipe.inscrever(cursoDotNet);
		felipe.inscrever(mentoria);
		
		felipe.progredir();
		System.out.println("XP: " + felipe.calcularTotalXp());
		System.out.println("\n-----------\n");
		
		felipe.inscrever(bootcamp);
		felipe.progredir();
		System.out.println("XP: " + felipe.calcularTotalXp());
		System.out.println("\n-----------\n");
		
		Dev jonas = new Dev();
		jonas.setNome("Jonas");
		
		jonas.inscrever(bootcamp);
		jonas.progredir();
		System.out.println("XP: " + jonas.calcularTotalXp());
		System.out.println("\n-----------\n");
		
		Dev marina = new Dev();
		marina.setNome("Marina");
		
		marina.inscrever(cursoJava);
		marina.progredir();
		marina.inscrever(cursoJavaAvancado);
		marina.progredir();
		System.out.println("XP: " + marina.calcularTotalXp());
		System.out.println("\n-----------\n");
		
		System.out.println(String.format("XP total do Felipe: %.2f", felipe.calcularTotalXp()));
		System.out.println(String.format("XP total do Jonas: %.2f", jonas.calcularTotalXp()));
		System.out.println(String.format("XP total da Marina: %.2f", marina.calcularTotalXp()));
		
		// Determinar o jogador com mais XP
		List<Dev> devs = Arrays.asList(felipe, jonas, marina);
		Dev topDev = devs.get(0);
		boolean empate = false;

		for (Dev dev : devs) {
		    if (dev.calcularTotalXp() > topDev.calcularTotalXp()) {
		        topDev = dev;
		        empate = false;
		    } else if (dev.calcularTotalXp() == topDev.calcularTotalXp() && dev != topDev) {
		        empate = true;
		    }
		}

		if (empate) {
		    System.out.println("Houve um empate entre os jogadores com mais XP.");
		} else {
		    System.out.println("O jogador com mais XP é: " + topDev.getNome() + " com " + topDev.calcularTotalXp() + " XP.");
		}

		//alternativa: ordena a lista de devs pelo XP e imprime em ordem decrescente
		List<Dev> devsSort = Arrays.asList(felipe, jonas, marina).stream()
				.sorted(Comparator.comparing(Dev::calcularTotalXp).reversed()).collect(Collectors.toList());

		for (Dev dev : devsSort) {
		    System.out.println(dev.getNome() + " - XP: " + dev.calcularTotalXp());
		}
		
	}

	

}
