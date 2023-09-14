package br.com.contaAzul.services;

import org.springframework.stereotype.Service;

import br.com.contaAzul.exceptions.BadRequestException;
import br.com.contaAzul.model.Posicao;
import br.com.contaAzul.model.Terreno;

@Service
public class RoboService {

	private Terreno terreno;
	private Posicao posicaoRobo, posicaoRealmatriz;

	
	public RoboService() {

	}
	
	public void init(int x, int y, char o, Terreno terreno) {
		posicaoRobo = new Posicao(x, y, o);
		posicaoRealmatriz = new Posicao(x, y, o);
		this.terreno = terreno;
		realToMat();
		terreno.moveRobo(posicaoRealmatriz);
	}

	
	public void andar(String pos) throws BadRequestException {
		terreno.limpaTerreno(posicaoRealmatriz);
		posicaoRealmatriz.setPosicao(pos, terreno.getTamanho());
		matToReal();
		terreno.moveRobo(posicaoRealmatriz);
	}

	public String posToString() {
		return posicaoRobo.getPosicao();
	}

	public void realToMat() {
		posicaoRealmatriz.setX(Math.abs(posicaoRobo.getX() - (terreno.getTamanho() - 1)));
		posicaoRealmatriz.setY(posicaoRobo.getY());
		posicaoRealmatriz.setOrientacao(posicaoRobo.getOrientacao());
	}

	public void matToReal() {
		posicaoRobo.setX(Math.abs(posicaoRealmatriz.getY()));
		posicaoRobo.setY(Math.abs(posicaoRealmatriz.getX() - (terreno.getTamanho() - 1)));
		posicaoRobo.setOrientacao(posicaoRealmatriz.getOrientacao());
	}
}
