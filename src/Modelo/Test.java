package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Session s;
		SessionFactory sessionFactory;
		String nombre;
		Date fechaDeNacimiento = null;
		String nacionalidad;

		int Seleccion = 0;
		Test t = new Test();
		int i = 1;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		s = sessionFactory.openSession();
		Actores actor = new Actores();
		System.out.println(
				"Bienvenido a la aplicacion de HIBERNATE con clase autogeneradas. Seleccione que BBDD quiere usar:");
		System.out.println("1. Consultar datos");
		System.out.println("2. Añadir datos");
		System.out.println("3. Borrar datos");

		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		Seleccion = entradaEscaner.nextInt();
		if (Seleccion == 1) {
			System.out.println("¿Consultar actores o peliculas?");
			System.out.println("1. Actores");
			System.out.println("2. Peliculas");
			Seleccion = entradaEscaner.nextInt();
			if (Seleccion == 1) {
				Query q = s.createQuery("SELECT j FROM Actores j");
				List results = q.list();

				Iterator consulta = results.iterator();

				while (consulta.hasNext()) {
					Actores actor2 = (Actores) consulta.next();
					System.out.println("Actor: " + i);
					System.out.println("Codigo: " + actor2.getCodigo());
					System.out.println("Nombre: " + actor2.getNombre());
					System.out.println("Fecha de nacimiento: " + actor2.getFNacimiento().toString());
					System.out.println("Nacionalidad: " + actor2.getNacionalidad());
					i++;
					System.out.println("----------------------");
				}
			} else if (Seleccion == 2) {
				Query q = s.createQuery("SELECT j FROM Peliculas j");
				List results = q.list();

				Iterator consulta = results.iterator();

				while (consulta.hasNext()) {
					Peliculas peliculas = (Peliculas) consulta.next();
					System.out.println("Pelicula: " + i);
					System.out.println("Codigo: " + peliculas.getCodigo());
					System.out.println("Titulo: " + peliculas.getTitulo());
					System.out.println("Fecha: " + peliculas.getFecha().toString());
					System.out.println("Presupuesto: " + peliculas.getPresupuesto());
					i++;
					System.out.println("----------------------");
				}
			}

		} else if (Seleccion == 2) {

			System.out.println("¿Añadir actores o peliculas?");
			System.out.println("1. Actores");
			System.out.println("2. Peliculas");
			Seleccion = entradaEscaner.nextInt();
			if (Seleccion == 1) {
				s.beginTransaction();
				Scanner entradaEscaner1 = new Scanner(System.in); // Creación de un objeto Scanner
				System.out.println("Nombre del actor:");
				nombre = entradaEscaner1.nextLine();

				System.out.println("Fecha de nacimiento del actor:");
				String string = entradaEscaner1.nextLine();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					fechaDeNacimiento = format.parse(string);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(fechaDeNacimiento.toString());
				System.out.println("Nacionalidad del actor:");
				nacionalidad = entradaEscaner1.nextLine();

				Actores actor2 = new Actores(nombre, fechaDeNacimiento, nacionalidad);
				System.out.println(actor2);
				s.save(actor2);
				s.getTransaction().commit();
				System.out.println("Actor añadido correctamente");

			} else if (Seleccion == 2) {
				s.beginTransaction();
				Scanner entradaEscaner1 = new Scanner(System.in); // Creación de un objeto Scanner
				System.out.println("Nombre de la pelicula:");
				nombre = entradaEscaner1.nextLine();
				System.out.println("Fecha de la pelicula:");
				String string = entradaEscaner1.nextLine();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					fechaDeNacimiento = format.parse(string);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Presupuesto de la pelicula:");
				Double pre = entradaEscaner1.nextDouble();

				Peliculas Peliculas = new Peliculas(nombre, fechaDeNacimiento, pre);
				System.out.println(Peliculas);
				s.save(Peliculas);
				s.getTransaction().commit();
			}

		}

		else if (Seleccion == 3) {

			System.out.println("¿Eliminar actores o peliculas?");
			System.out.println("1. Actores");
			System.out.println("2. Peliculas");
			Seleccion = entradaEscaner.nextInt();
			if (Seleccion == 1) {
				s.beginTransaction();
				Scanner entradaEscaner1 = new Scanner(System.in); // Creación de un objeto Scanner
				System.out.println("Codigo del actor:");
				nombre = entradaEscaner1.nextLine();

				s.beginTransaction();
				Query q= s.createQuery("delete from Actores WHERE Codigo ='"+nombre+"'");
				q.executeUpdate();
				s.getTransaction().commit();
				System.out.println("borrado uno con exito");

			} else if (Seleccion == 2) {
				s.beginTransaction();
				Scanner entradaEscaner1 = new Scanner(System.in); // Creación de un objeto Scanner
				System.out.println("Codigo de la pelicula:");
				nombre = entradaEscaner1.nextLine();

				s.beginTransaction();
				Query q= s.createQuery("delete from Peliculas WHERE Codigo ='"+nombre+"'");
				q.executeUpdate();
				s.getTransaction().commit();
				System.out.println("borrado uno con exito");
			}

		}

	}
}
