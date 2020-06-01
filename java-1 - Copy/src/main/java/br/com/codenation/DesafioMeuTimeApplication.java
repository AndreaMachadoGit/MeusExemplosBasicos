package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.classes.Jogador;
import br.com.codenation.desafio.classes.Time;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.repositorios.RepositorioJogador;
import br.com.codenation.desafio.repositorios.RepositorioTime;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	RepositorioTime repositorioTime = new RepositorioTime();
	RepositorioJogador repositorioJogador = new RepositorioJogador();
	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscarTime(id) != null) try {
			throw new IdentificadorUtilizadoException();
		} catch (IdentificadorUtilizadoException e) {
			e.printStackTrace();
		}
		try {
			times.add( new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		} catch (IdentificadorUtilizadoException e) {
			e.printStackTrace();
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		try {
			Jogador jogador1;
			if (repositorioJogador.search(id) != null) { // Verifica se o jogador  já existe na lista de jogadores
				throw new IdentificadorUtilizadoException();
			} else if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				jogador1 = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
				repositorioJogador.add(jogador1);
			}
		} catch (IdentificadorUtilizadoException | TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		try {
			if (repositorioJogador.search(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores
				throw new JogadorNaoEncontradoException();
			} else {
				Jogador jogador1 = repositorioJogador.search(idJogador);
				Time time1 = repositorioTime.search(jogador1.getIdTime());
				time1.setIdCapitao(idJogador);
			}
		} catch(JogadorNaoEncontradoException e) {
			e.printStackTrace();
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Long idCaptao = null;
		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				Time time1 = repositorioTime.search(idTime);
				if (time1.getIdCapitao() == null) {
					throw new CapitaoNaoInformadoException();
				} else {
					idCaptao = time1.getIdCapitao();
				}
			}
		} catch(TimeNaoEncontradoException | CapitaoNaoInformadoException e) {
			e.printStackTrace();
		}
		return idCaptao;
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		String nomeJogador = null;
		try {
			if (repositorioJogador.search(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores
				throw new JogadorNaoEncontradoException();
			} else {
				Jogador jogador1 = repositorioJogador.search(idJogador);
				nomeJogador = jogador1.getNome();
			}
		} catch(JogadorNaoEncontradoException e) {
			e.printStackTrace();
		}
		return  nomeJogador;
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		String nomeTime = null;
		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				Time time1 = repositorioTime.search(idTime);
				nomeTime = time1.getNome();
			}
		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
		return nomeTime;
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> listaJogadores = null;

		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
			throw new TimeNaoEncontradoException();
		} else {
				listaJogadores = repositorioJogador.buscarJogadoresDoTime(idTime);
		}

		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}

		return listaJogadores;

	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Long melhorJogador = null;
		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				melhorJogador = repositorioJogador.buscarMelhorJogadorDoTime(idTime);
			}

		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
		return melhorJogador;
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Long jogadorMaisVelho = null;
		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				jogadorMaisVelho = repositorioJogador.buscarJogadorMaisVelho(idTime);
			}

		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
		return jogadorMaisVelho;

	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return repositorioTime.findAll();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Long jogadorMaiorSalario = null;
		try {
			if (repositorioTime.search(idTime) == null) { // Verifica se o time não está cadastrado na lista de times
				throw new TimeNaoEncontradoException();
			} else {
				jogadorMaiorSalario = repositorioJogador.buscarJogadorMaiorSalario(idTime);
			}

		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
		return jogadorMaiorSalario;
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		BigDecimal salarioJogador = null;
		try {
			if (repositorioJogador.search(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores
				throw new JogadorNaoEncontradoException();
			} else {
				Jogador jogador1 = repositorioJogador.search(idJogador);
				salarioJogador = jogador1.getSalario();
			}
		} catch(JogadorNaoEncontradoException e) {
			e.printStackTrace();
		}
		return  salarioJogador;
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return repositorioJogador.buscarTopJogadores(top);
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = repositorioTime.search(timeDaCasa);
		Time timeFora = repositorioTime.search(timeDeFora);
		String corCamisaTimeFora = null;

		try {
			if (timeCasa == null || timeFora == null) {
				throw new  TimeNaoEncontradoException();
			} else {
				if (timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())) {
					corCamisaTimeFora = timeFora.getCorUniformeSecundario();
				}
				corCamisaTimeFora =  timeFora.getCorUniformePrincipal();

			}

		} catch(TimeNaoEncontradoException e) {
			e.printStackTrace();
		}
		return corCamisaTimeFora;
	}


	private Time buscarTime(Long idTime) {
		return times.stream().filter(x -> x.getId().equals(idTime)).findFirst().orElse(null);
	}

	private Jogador buscarJogador(Long idJogador) {
		return jogadores.stream().filter(x -> x.getId().equals(idJogador)).findFirst().orElse(null);
	}

}
