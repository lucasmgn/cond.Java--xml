package com.curso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.curso.modelo.Produto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class LendoCarrinho {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.addPermission(AnyTypePermission.ANY);
		xstream.alias("produto", Produto.class);
		xstream.aliasAttribute(Produto.class, "codigo", "codigo");
		xstream.alias("carrinho", List.class);
		
		List<Produto> carrinho = (List<Produto>) xstream.fromXML(new FileInputStream("./carrinho.xml"));
		
		for(Produto p : carrinho) {
			System.out.println("O código do produto:" + p.getCodigo());
			System.out.println("Descrição: " + p.getDescricao());
			System.out.println("Valor: " + p.getValor());
			System.out.println("");
		}
	}
}
