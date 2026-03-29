import { useState } from 'react';
import '../styles/Login.css';

function Login() {
    
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        console.log('Login:', formData);
    };

    return (
        <div className="login-page">
            <div className="login-layout">
                <div className="login-hero">
                    <div className="login-hero-overlay" />
                    <div className="login-hero-content">
                        <div className="login-hero-header">
                            <h1>InHomeHub</h1>
                        </div>
                        <p>Gestão moderna e simples para o seu condomínio.</p>
                        <ul>
                            <li>Acompanhe comunicados em tempo real</li>
                            <li>Centralize conflitos e votação de decisões</li>
                            <li>Histórico organizado para todos os moradores</li>
                        </ul>
                    </div>
                </div>

                <div className="login-container">
                    <div className="login-card">
                        <div className="login-header">
                            <h2>Bem-vindo de volta</h2>
                            <p>Acesse sua conta para continuar</p>
                        </div>

                        <form className="login-form" onSubmit={handleSubmit}>
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

                            <div className="login-actions">
                                <a href="#" className="forgot-password">Esqueceu a senha?</a>
                            </div>

                            <button type="submit" className="login-button">Entrar</button>
                        </form>

                        <div className="signup-link">
                            Não tem uma conta? <a href="/register">Cadastre-se</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;