# GitHub Professional

Configuration of the GitHub repository for the Spring Boot Lab.

## 1. Repository

Repository: `springboot-lab`

Purpose:

Laboratorio de arquitectura de software moderna y DevOps.

The repository is configured with:

- Public visibility
- Default branch: `develop`
- README
- Repository topics related to the technologies and architecture used by the lab

Current topics:

- aws
- devops
- docker
- github-actions
- software-architecture
- spring-boot

## 2. Branch Protection

The `develop` branch is protected by the `Protect develop` ruleset.

Current rules:

- Pull requests are required before changes can be made to `develop`
- Force pushes are blocked
- Branch deletion is restricted

The purpose of this protection is to prevent direct changes to the integration branch and enforce the Pull Request workflow.

Expected workflow:

```text
feature/*
    ↓
Pull Request
    ↓
develop
```

## 3. Releases

The repository uses Git tags and GitHub Releases to identify published versions.

Current release:

- `v1.2.1`
- Title: `v1.2.1 - Critical production bug fix`
- Based on tag: `v1.2.1`

The release represents the state of the repository identified by the corresponding Git tag.

## 4. Secrets

Repository secrets are managed through:

`Settings → Secrets and variables → Actions`

Secrets are intended for sensitive configuration data and credentials.

No laboratory secret is currently stored in the repository.

Example used during the lab:

- `LAB_DEMO_SECRET` — created temporarily and removed after the exercise.

## 5. Environments

The repository contains two GitHub Environments:

### development

Allowed deployment branch:

- `develop`

Purpose:

Represent the development deployment environment.

### production

Allowed deployment branch:

- `main`

Purpose:

Represent the production deployment environment.

Production is intended to represent a controlled deployment target.

## 6. Container Registry

The repository uses GitHub Container Registry (GHCR).

Container image:

```text
ghcr.io/rastben/springboot-lab:1.2.1
```

The image corresponds to Git tag `v1.2.1`.

The image is linked to this repository through:

```text
org.opencontainers.image.source
```

Source repository:

```text
https://github.com/rastben/springboot-lab
```

## 7. Issues

GitHub Issues are used to track project work.

Examples created during the lab:

- Issue #3 — Add automated tests for Product validation
- Issue #5 — Document GitHub project configuration

Issues can be connected to branches and Pull Requests to provide traceability.

Example workflow:

```text
Issue
  ↓
Branch
  ↓
Commit
  ↓
Pull Request
  ↓
Merge
  ↓
Issue closed
```

## 8. Projects

The repository uses a GitHub Project named:

`Spring Boot Lab`

Current views:

- Board
- Table

The Board is used to visualize work by status:

```text
Todo
In Progress
Done
```

The Table provides a structured view of the project items.

Projects organize and visualize Issues and Pull Requests without replacing the Issues themselves.

## Relationship between components

The GitHub configuration can be summarized as:

```text
                    GitHub Repository
                           │
          ┌────────────────┼────────────────┐
          │                │                │
       Branches          Issues          Projects
          │                │                │
   Branch Protection       │                │
          │                │                │
          └────── Pull Requests ───────────┘
                           │
                         Merge
                           │
                        develop

Repository configuration
        │
        ├── Secrets
        ├── Environments
        └── Container Registry

Git tags
    │
    └── GitHub Releases
```

## Phase 5 status

GitHub Professional configuration completed:

- Repository
- Branch Protection
- Releases
- Secrets
- Environments
- Container Registry
- Issues
- Projects
- Documentation