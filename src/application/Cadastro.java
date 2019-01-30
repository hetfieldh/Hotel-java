package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Cadastro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.print("Número do Quarto: ");
			int numeroQuarto = sc.nextInt();

			System.out.print("Data de CHECK-IN: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de CHECK-OUT: ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Entre com as datas de reserva atualizadas: ");

			System.out.print("Data de CHECK-IN: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de CHECK-OUT: ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

		} catch (ParseException e) {
			System.out.println("Formato de data inválida!");
		} catch (DomainException e) {
			System.out.println("ERRO NA RESERVA: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado...");
		}

		sc.close();
	}
}