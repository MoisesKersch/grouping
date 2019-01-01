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
		List<Foo> foos = getLocalFoo();

		List<Eua> euas = new ArrayList<>(); // criado endereco 1

		Ua ua = new Ua();

		for (Foo foo : foos)
		{
			Eua eua = gEua(euas, foo, ua); // ua apontado uara o endereço 2

			if (eua.getUas().size() > 0)
				ua = eua.getUas().get(eua.getUas().size() - 1);

			A a = new A();
			a.setNome(foo.getNome());
			ua.getAs().add(a);

		}

		System.out.println(euas);
	}

	public static Eua gEua(List<Eua> euas, Foo foo, Ua ua)
	{
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

		Eua eua = new Eua(); // criado endereço 2

		eua.setEmpresaId(foo.getEmpresaId());
		ua = new Ua();
		
		eua.getUas().add(ua);
		ua.setUsuarioId(foo.getUsuarioId());
		euas.add(eua);
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