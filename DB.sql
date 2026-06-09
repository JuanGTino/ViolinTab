CREATE DATABASE IF NOT EXISTS violin_hub;
USE violin_hub;

-- 1. Tabla de Partituras (Biblioteca principal)
CREATE TABLE IF NOT EXISTS sheet_music (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    composer VARCHAR(100),
    category VARCHAR(50), -- Ej: 'Grade 1', 'Anime', 'Pop'
    pdf_path VARCHAR(500), -- Ruta del archivo en el sistema
    status ENUM('por_aprender', 'en_proceso', 'dominado') DEFAULT 'por_aprender',
    is_favorite BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 2. Tabla de Sesiones de Practica (Estadisticas)
CREATE TABLE IF NOT EXISTS practice_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sheet_music_id INT, -- Puede ser NULL si es practica de tecnica general
    practice_date DATE NOT NULL,
    duration_minutes INT NOT NULL,
    max_bpm INT, -- Progreso de velocidad con metronomo
    technique_focus VARCHAR(255), -- Ej: 'Vibrato', 'Escalas'
    FOREIGN KEY (sheet_music_id) REFERENCES sheet_music(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- 3. Centro de Notas (Anotaciones y Audio)
CREATE TABLE IF NOT EXISTS notes_center (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sheet_music_id INT,
    note_type ENUM('texto', 'audio') NOT NULL,
    content TEXT, -- Texto de la nota o ruta al archivo de audio
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sheet_music_id) REFERENCES sheet_music(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 4. Recursos Multimedia (Links a tutoriales o referencias)
CREATE TABLE IF NOT EXISTS resources_links (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sheet_music_id INT NOT NULL,
    url_path VARCHAR(500) NOT NULL, -- Link de YouTube o referencia externa
    description VARCHAR(255),
    FOREIGN KEY (sheet_music_id) REFERENCES sheet_music(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 5. Registro de Mantenimiento del Violin
CREATE TABLE IF NOT EXISTS maintenance_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    action_type VARCHAR(100) NOT NULL, -- Ej: 'Cambio de cuerdas', 'Resina'
    date_performed DATE NOT NULL,
    next_due_date DATE, -- Fecha sugerida para el siguiente mantenimiento
    notes TEXT
) ENGINE=InnoDB;

