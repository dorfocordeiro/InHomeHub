import { useState } from 'react';
import '../styles/Register.css';

function Register() {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
    });

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        console.log('Register:', formData);
    };

    return (
        <div className="register-page">
            <div className="register-layout">
                <div className="register-hero">
                    <div className="register-hero-overlay" />
                    <div className="register-hero-content">
                        <h1 className="inhomehub-hero-register">InHomeHub</h1>
                        <p>Junte-se a milhares de condomínios</p>
                        <ul>
                            <li>Gestão completa e intuitiva</li>
                            <li>Comunicação eficiente com moradores</li>
                            <li>Relatórios e histórico detalhados</li>
                        </ul>
                    </div>
                </div>

                <div className="register-container">
                    <div className="register-card">
                        <div className="register-header">
                            <h2>Criar conta</h2>
                            <p>Preencha os dados para começar</p>
                        </div>

                        <form className="register-form" onSubmit={handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="name">Nome completo</label>
                                <input
                                    id="name"
                                    type="text"
                                    placeholder="Seu nome"
                                    value={formData.name}
                                    onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                                    required
                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <input
                                    id="email"
                                    type="email"
                                    placeholder="seu@email.com"
                                    value={formData.email}
                                    onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                                    required
                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="password">Senha</label>
                                <input
                                    id="password"
                                    type="password"
                                    placeholder="••••••••"
                                    value={formData.password}
                                    onChange={(e) => setFormData({ ...formData, password: e.target.value })}
                                    required
                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="confirmPassword">Confirmar senha</label>
                                <input
                                    id="confirmPassword"
                                    type="password"
                                    placeholder="••••••••"
                                    value={formData.confirmPassword}
                                    onChange={(e) => setFormData({ ...formData, confirmPassword: e.target.value })}
                                    required
                                />
                            </div>

                            <button type="submit" className="register-button">Cadastrar</button>
                        </form>

                        <div className="login-link">
                            Já tem uma conta? <a href="/">Entrar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;
