import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Servicos.css";

function Servico() {
  const [servico, setServico] = useState({
    nome: "",
    dataInicio: "",
    dataTermino: "",
    descricao: "",
    valor: "",
    valorRecebido: "",
    dataPagamento: "",
  });

  const [servicos, setServicos] = useState([]);

  function handleChange(event) {
    setServico({ ...servico, [event.target.name]: event.target.value });
  }

  function handleSubmit(event) {
    event.preventDefault();
    {
      /**console.log(servico);} */
    }
    axios
      .post("http://localhost:8080/api/backservice/cadastrar", servico)
      .then((result) => {
        console.log(result);
      });
  }

  return (
    <div className="container">
      <h1>Cadastro de Serviços</h1>
      <form onSubmit={handleSubmit}>
        <div className="col-6">
          <div>
            <label className="form-label">Nome do Cliente:</label>
            <input
              onChange={handleChange}
              value={servico.nome}
              className="form-control"
              type="text"
              placeholder="Digite o nome"
              name="nome"
            />
          </div>
          <div>
            <label className="form-label">Data Término:</label>
            <input
              onChange={handleChange}
              value={servico.dataTermino}
              className="form-control"
              type="date"
              name="dataTermino"
            />
          </div>
          <div>
            <label className="form-label">Descrição do Serviço:</label>
            <input
              onChange={handleChange}
              value={servico.descricao}
              className="form-control"
              type="text"
              placeholder="Digite a descrição"
              name="descricao"
            />
          </div>
          <div>
            <label className="form-label">Valor:</label>
            <input
              onChange={handleChange}
              value={servico.valor}
              className="form-control"
              type="number"
              placeholder="Digite o valor do serviço R$"
              name="valor"
            />
          </div>
          <div>
            <label className="form-label">Valor Pago:</label>
            <input
              onChange={handleChange}
              value={servico.valorRecebido}
              className="form-control"
              type="number"
              placeholder="Digite o valor pago R$"
              name="valorRecebido"
            />
          </div>
          <div>
            <label className="form-label">Data Pagamento:</label>
            <input
              onChange={handleChange}
              value={servico.dataPagamento}
              className="form-control"
              type="date"
              name="dataPagamento"
            />
          </div>
          <br />
          <button type="submit" className="btn btn-success">
            Cadastrar
          </button>
        </div>
      </form>
    </div>
  );
}

export default Servico;
