package grouping;

import java.util.ArrayList;
import java.util.List;

public class Group
{
	public static List<Foo> getLocalFoo()
	{
		List<Foo> foos = new ArrayList<>();

		Foo foo = new Foo();

		foo.setId(1l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("2");
		foo.setNome("Maria");

		foos.add(foo);
		foo = new Foo();

		foo.setId(2l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("3");
		foo.setNome("Marcelo");

		foos.add(foo);
		foo = new Foo();

		foo.setId(3l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("3");
		foo.setNome("Bidu");

		foos.add(foo);
		foo = new Foo();

		foo.setId(4l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("3");
		foo.setNome("Jose");

		foos.add(foo);
		foo = new Foo();

		foo.setId(5l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("3");
		foo.setNome("Mario");

		foos.add(foo);
		foo = new Foo();

		foo.setId(6l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("69");
		foo.setNome("Joselito");

		foos.add(foo);
		foo = new Foo();

		foo.setId(7l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("141");
		foo.setNome("Caroline");

		foos.add(foo);
		foo = new Foo();

		foo.setId(8l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("141");
		foo.setNome("Jorge");

		foos.add(foo);
		foo = new Foo();

		foo.setId(9l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("141");
		foo.setNome("Anderson");

		foos.add(foo);
		foo = new Foo();

		foo.setId(10l);
		foo.setEmpresaId("1");
		foo.setUsuarioId("161");
		foo.setNome("Manoel");

		foos.add(foo);
		foo = new Foo();
		foo.setId(11l);
		foo.setEmpresaId("2");
		foo.setUsuarioId("2");
		foo.setNome("Amanda");

		foos.add(foo);
		foo = new Foo();

		foo.setId(12l);
		foo.setEmpresaId("2");
		foo.setUsuarioId("2");
		foo.setNome("Sandra");

		foos.add(foo);
		foo = new Foo();

		foo.setId(13l);
		foo.setEmpresaId("2");
		foo.setUsuarioId("12");
		foo.setNome("Hikari");

		foos.add(foo);

		return foos;
	}

	public static void main(String[] args)
	{
		// 1 carregando os dados todos desagrupados
		List<Foo> foos = getLocalFoo();

		// 2 criando o array principal que vai guardar os dados agrupados
		// * Esse array ira manter sempre apontado, durante toda a execução do codigo,
		// par um lugar estatico na memoria. Vamos chamar esse endereço de m1
		List<Eua> euas = new ArrayList<>(); 

		// * 3Varievel auxiliar para guardar dados que vao entrar no sub array do array principal
		// * Essa variavel tambem utilizara muito a tecnica de apontar para um lugar especifico na memoria.
		Ua ua = null;

		// 4 loop dentro do array desagrupado
		for (Foo foo : foos)
		{
			// 5 essa varivel vai apontar para um espaço na memoria inicializado no metodo gEua.
			// vamos chama-lo de m2
			// no metodo gEua estamos passando 2 endereços de memoria ja citados
			// gEua(m1, ?, m2) 
			// 14 estamos agora apontando e eua abaixo na m4 gerada pela funcao gEua
			Eua eua = gEua(euas, foo, ua); 
			
			// caso o ua nao esteja apontado para o mesmo lugar do euaGetUas
			// entao o apontamos para essa direção
			if ( !(ua == eua.getUas().get(eua.getUas().size() - 1)) )
			{
				ua = eua.getUas().get(eua.getUas().size() - 1);
			}

			// criamos um item, a adicionamos dentro desse eu.
			A a = new A();
			a.setNome(foo.getNome());
			ua.getAs().add(a);
		}

		System.out.println(euas);
	}

	public static Eua gEua(List<Eua> euas, Foo foo, Ua ua)
	{
		// 6 vamos entrar dentro do endereço de memoria m1 nessa execuçao
		// na primera interaçao como o array eh vazio ele nao vai entrar nesse loop
		for (Eua eua : euas)
		{
			if (eua.getEmpresaId().equals(foo.getEmpresaId()))
			{
				if (!ua.getUsuarioId().equals(foo.getUsuarioId()))
				{
					ua = new Ua();
					ua.setUsuarioId(foo.getUsuarioId());
					eua.getUas().add(ua);
					return eua;
				}
				return eua;
			}
		}
		
		// 7 Criando uma nova instancia do objeto principal 
		// vamos chamar esse endereço de m4 
		Eua eua = new Eua(); // criado endereço 2

		// 8 adiciona o nome da empresa no objeto m4
		eua.setEmpresaId(foo.getEmpresaId());
		
		// 9 aponta o ua para algum lugar na memoria, vamos chamar esse lugar de m5
		ua = new Ua();
		
		// 10 adiciona o m5 dentro do m4
		eua.getUas().add(ua);
		
		// 11 adiciona nome do usuario na m5
		ua.setUsuarioId(foo.getUsuarioId());
		
		// 12 vadiciona o objeto na m1
		euas.add(eua);
		
		// 13 retorna a m4
		return eua;
	}
}

class Eua
{
	String empresaId;
	List<Ua> uas = new ArrayList<>();

	public String getEmpresaId()
	{
		return empresaId;
	}

	public void setEmpresaId(String empresaId)
	{
		this.empresaId = empresaId;
	}

	public List<Ua> getUas()
	{
		return uas;
	}

	public void setUas(List<Ua> uas)
	{
		this.uas = uas;
	}
}

class Ua
{
	String usuarioId;
	List<A> as = new ArrayList<>();

	public void setUsuarioId(String usuarioId)
	{
		this.usuarioId = usuarioId;
	}

	public String getUsuarioId()
	{
		return this.usuarioId;
	}

	public void setA(List<A> as)
	{
		this.as = as;
	}

	public List<A> getAs()
	{
		return this.as;
	}
}

class A
{
	String nome;

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getUsuarioId()
	{
		return this.nome;
	}
}

// objeto principal
class Foo
{
	private Long id;
	private String empresaId;
	private String usuarioId;
	private String nome;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsuarioId()
	{
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId)
	{
		this.usuarioId = usuarioId;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmpresaId()
	{
		return empresaId;
	}

	public void setEmpresaId(String empresaId)
	{
		this.empresaId = empresaId;
	}
}